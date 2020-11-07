package com.icaballero.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaballero.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {

		model.addAttribute("titulo", textoIndex);

		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario user = new Usuario();
		user.setNombre("ismael");
		user.setApellido("Caballero");
		user.setEmail("icaballero.com");

		model.addAttribute("usuario", user);
		model.addAttribute("titulo", textoPerfil.concat(user.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoListar);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {

		List<Usuario> listaUsuario = new ArrayList<>();

		Usuario user = new Usuario();
		user.setNombre("ismael");
		user.setApellido("Caballero");
		user.setEmail("icaballero.com");

		Usuario user2 = new Usuario();
		user2.setNombre("Cristian");
		user2.setApellido("perez");
		user2.setEmail("cperez.com");

		Usuario user3 = new Usuario();
		user3.setNombre("Gerard");
		user3.setApellido("sanchez");
		user3.setEmail("cperez.com");

		listaUsuario.add(user);
		listaUsuario.add(user2);
		listaUsuario.add(user3);

		return listaUsuario;
	}

//	@GetMapping({"/index", "/", "/home"})
//	public String index(ModelMap model) {
//		
//		model.addAttribute("titulo", "Hola Spring Framwork con ModelMap!");
//		
//		return "index";
//	}

//	@GetMapping({"/index", "/", "/home"})
//	public String index(Map<String, Object> model) {
//		
//		model.put("titulo", "Hola Spring Framwork con Map!");
//		
//		return "index";
//	}

//	@GetMapping({"/index", "/", "/home"})
//	public ModelAndView index(ModelAndView model) {
//		
//		model.addObject("titulo", "Hola Spring Framwork con ModelAndView!");
//		model.setViewName("index");
//		
//		return model;
//	}
//	

}
