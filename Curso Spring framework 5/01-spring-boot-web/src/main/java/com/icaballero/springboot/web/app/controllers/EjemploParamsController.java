package com.icaballero.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {

		return "params/index";
	}

	@GetMapping("string")
	public String params(
			@RequestParam(name = "texto", required = false, defaultValue = "algun valor ...") String textoOtro,
			Model model) {

		model.addAttribute("resultado", "El texto enviado es : ".concat(textoOtro));

		return "params/ver";

	}

	@GetMapping("/mix-params")
	public String params(@RequestParam String saludo,@RequestParam Integer numero , Model model) {
		
		model.addAttribute("resultado", "El saludo  es : '" + saludo +"' y el numero es '"+numero +"'");
		
		
		return "params/ver";
		
	}
	
	@GetMapping("/mix-params-request")
	public String params(HttpServletRequest request , Model model) {
		
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
		numero =Integer.parseInt(request.getParameter("numero"));
		}catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo  es : '" + saludo +"' y el numero es '"+numero +"'");
		
		
		return "params/ver";
		
	}
	
	

}
