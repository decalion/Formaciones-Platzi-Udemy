package com.icaballero.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HolaMundoController {
	
	
	@GetMapping("/")
	public String inicio() {
	
		log.info("Ejecutando controllador rest");
		log.debug("MAS DETALLES");
		return "Hola Mundo Con Spring";
	}
	

}
