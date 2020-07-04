package com.icaballero.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("mensaje", "Hola a Todos");
		
		return "index";
	}
	
	
	
	@GetMapping("/saludo")
	public String saludoCompleto(Model model) {
		
		model.addAttribute("mensaje", "Saludo a todos");
		
		return "saludo";
	}
	
	
	
	

}
