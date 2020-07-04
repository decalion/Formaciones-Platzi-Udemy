package com.icaballero.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String welcome(@RequestParam(name="name", required = false, defaultValue = "Ismael") String name,Model model) {
		
		//model.addAttribute("mensaje", "Hola a Todos");
		model.addAttribute("mensaje", name);
		return "index";
	}
	
	
	
	@GetMapping("/saludo/{name}")
	public String saludoCompleto(@PathVariable String name ,Model model) {
		
		model.addAttribute("mensaje", "Saludo " + name);
		
		return "saludo";
	}
	
	
	
	

}
