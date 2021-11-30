package com.ProjetoSpringBoot.projetosb;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmesController {
	@GetMapping("/esperados22")
	public String pageEsp22() {
		return "esperados22";
	}
	
	@GetMapping("/esperados23")
	public String pageEsp23() {
		return "esperados23";
	}
}