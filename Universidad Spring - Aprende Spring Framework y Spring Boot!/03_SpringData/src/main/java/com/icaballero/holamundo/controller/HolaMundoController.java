package com.icaballero.holamundo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.icaballero.holamundo.entity.Persona;
import com.icaballero.holamundo.services.IPersonaServices;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HolaMundoController {

	@Autowired
	private IPersonaServices personaService;

	@Value("${index.saludo}")
	private String saludo;

	@GetMapping("/")
	public String inicio(Model model) {

		log.info("Ejecutando controllador MVC");

		List<Persona> personas = personaService.listaPersona();

		model.addAttribute("personas", personas);

		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {

		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		
		personaService.guardar(persona);
		
		return "redirect:/";
	}
	
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
    	
        persona = personaService.encontrarPersona(persona);
        
        model.addAttribute("persona", persona);
        
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_persona}")
    public String eliminar(Persona persona, Model model){
    	
        personaService.eliminar(persona);
        
        
        
        return "redirect:/";
    }

    
    

}
