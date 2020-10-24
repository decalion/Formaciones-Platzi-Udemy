package com.icaballero.holamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icaballero.holamundo.domain.Persona;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HolaMundoController {
	
	@Value("${index.saludo}")
	private String saludo;
	
	@GetMapping("/")
	public String inicio(Model model) {
	
		log.info("Ejecutando controllador MVC");
		//log.debug("MAS DETALLES");
		
		String mensaje = "Hola mundo con Thymeleaf";
		
		Persona  persona = new Persona();
		persona.setNombre("Ismael");
		persona.setApellido("Caballero");
		persona.setEmail("icaballero@icaballlero.com");
		persona.setTelefono("666666666");
		
		Persona  persona2 = new Persona();
		persona2.setNombre("juan");
		persona2.setApellido("perez");
		persona2.setEmail("jperezo@icaballlero.com");
		persona2.setTelefono("777777777");
		
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(persona);
	    personas.add(persona2);
		
		
		
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		model.addAttribute("persona", persona);
		model.addAttribute("personas", personas);
		
		return "index";
	}
	

}
