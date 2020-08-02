package com.icaballero.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.app.domain.Persona;
import com.icaballero.app.services.PersonaService;

@RestController
@RequestMapping("webapi")
public class PersonaRestController {

	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/personas")
	public Iterable<Persona> buscarTodos() {

		return personaService.buscarTodos();
	}
	
	@PostMapping(path="/personas", consumes="application/json")
	public void insertar(@RequestBody Persona persona) {

		personaService.insertar(persona);
	}

	@DeleteMapping("/personas/{nombre}")
	public void borrar(@PathVariable String nombre) {
		
		Optional<Persona> persona = personaService.findById(nombre);

		if(persona.isPresent()) {
			personaService.borrar(persona.get());
		}
		
		
	}
	
}
