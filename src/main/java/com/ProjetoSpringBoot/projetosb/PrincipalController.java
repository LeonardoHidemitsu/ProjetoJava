package com.ProjetoSpringBoot.projetosb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	@GetMapping("/")
	public String pageHome() {
		return "index";
	}
	
	@GetMapping("/error") 
		public String pageError() {
			return "erro";
	}
}