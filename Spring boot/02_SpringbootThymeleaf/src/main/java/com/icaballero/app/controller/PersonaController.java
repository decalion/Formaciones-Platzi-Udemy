package com.icaballero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icaballero.app.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	@RequestMapping("/lista")
	public String mostrarPersonas(Model modelo) {
		
		modelo.addAttribute("lista",personaService.buscarTodos());
		
		return "personas/lista";
	}
	

}
