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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProjetoSpringBoot.projetosb.model.Editar;
import com.ProjetoSpringBoot.projetosb.model.EditarService;

@Controller
@ComponentScan("com.model")
public class EditarController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/editar")
	public String pageEdit(Model model) {
		model.addAttribute("editar", new Editar());
		return "editar";
	}
	
	@PostMapping("/editar")
	public String postEdit(@ModelAttribute Editar e, Model model) {
		EditarService e = context.getBean(EditarService.class);
		e.editarSugestao(e);
		return "sucesso-edit";
	}
	
	@GetMapping("/sugerirfilme/listar")
	public String listarSugestao (Model model) {
		EditarService edao = context.getBean(EditarService.class);
		List<Map<String,Object>> listarSugetsao = edao.getSugestao();
		model.addAttribute("Sugeridos", listarSugestao);
		return "listar";
	}
	
	@PostMapping("/listar/deletarSugestao/{id}") 
	public String deletarSugestao(@PathVariable("id") int id) {
		EditarService edao = context.getBean(EditarService.class);
		edao.deletarSugestao(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/updsugeridos/{id}") 
	public String atualizarSugestao(@PathVariable("id") int id, Model model) {
		EditarService edao = context.getBean(EditarService.class);
		Map<String,Object> regs = edao.getSugestao(id);
		Editar e = new Editar(id,regs.get("nome").toString(),
								 regs.get("sinopse").toString());
		model.addAttribute("sugestao", e);
		model.addAttribute("id", id);
		return "updsugestao";
	}
	
	@PostMapping("/editar/updsugeridos/{id}")
		public String atualizarSugestao(@PathVariable("id") int id, Model model, @ModelAttribute Editar e) {
		EditarService edao = context.getBean(EditarService.class);
		edao.atualizarSugestao(id, e);
		return "redirect:/updsugestao";
	}
}