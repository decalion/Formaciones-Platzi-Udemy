package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String tituloIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String tituloPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String tituloListar;

	@GetMapping({ "/index", "/", "", "home" })
	public String index(Model model) {

		model.addAttribute("titulo", tituloIndex);

		return "index";
	}

	// Si no se indica el method por defecto es GET
	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Ismael");
		usuario.setApellido("Caballero");
		usuario.setEmail("text@correo.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloPerfil + " " + usuario.getNombre());

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", tituloListar);

		return "listar";
	}

	
	
	
	
	//Con la anotacion modelAttribut estamos definiendo que el atributo esta definido en todas las vistas
	@ModelAttribute("usuarios")
	public List<Usuario> pasarUsuariosVista() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Ismael", "Caballero", "icaballero@test.org"));
		usuarios.add(new Usuario("Cristian", "Bautista", "cbautistao@test.org"));
		usuarios.add(new Usuario("Gerard", "Exposito", "gexposito@test.org"));
		usuarios.add(new Usuario("Agusti", "Montes", "amontes@test.org"));

		return usuarios;
	}

}
