package com.ProjetoSpringBoot.projetosb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProjetoSpringBoot.projetosb.model.EditarService;
import com.ProjetoSpringBoot.projetosb.model.Sugestao;
import com.ProjetoSpringBoot.projetosb.model.SugestaoService;

@Controller
@ComponentScan("com.model")
public class SugestaoController {
	
	@Autowired
	ApplicationContext context;
	
	@GetMapping("/sugerirfilme")
	public String pageSugestao(Model model) {
		model.addAttribute("sugestao", new Sugestao());
		return "sugestao";
	}
	
	@PostMapping("/sugerirfilme/inserirSugestao")
	public String postSugerir(@ModelAttribute Sugestao s, Model model) {
		SugestaoService ss = context.getBean(SugestaoService.class);
		ss.inserirSugestao(s);
		return "sucesso-sugestao";
	}
	
	@GetMapping("/inserirSugestao/editarSugestao")
	public String editarSugestao (Model model) {
		EditarService sdao = context.getBean(EditarService.class);
		List<Map<String,Object>> editarSugestao = sdao.getSugestao();
		model.addAttribute("Editar", editarSugestao);
		return "editar";
	}
}