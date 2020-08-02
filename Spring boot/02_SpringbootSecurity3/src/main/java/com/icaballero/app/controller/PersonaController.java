package com.icaballero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icaballero.app.domain.Persona;
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
	
	@RequestMapping("/formularioinsertar")
	public String formularioInsertar() {
		
		return "personas/formularioinsertar";
	}
	
	
	@RequestMapping("/insertar")
	public String insertar(Persona persona, Model modelo) {
		
		personaService.insertar(persona);
		modelo.addAttribute("lista", personaService.buscarTodos());
		
		return "personas/lista";
	}
	
	@RequestMapping("/borrar")
	public String borrar(@RequestParam("nombre") String nombre, Model modelo) {
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		
		personaService.borrar(persona);
		modelo.addAttribute("lista", personaService.buscarTodos());
		
		return "personas/lista";
	}

}
