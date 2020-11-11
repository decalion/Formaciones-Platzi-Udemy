package com.icaballero.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.icaballero.springboot.form.app.editors.NombreMayusculaEditors;
import com.icaballero.springboot.form.app.editors.PaisPropertyEditors;
import com.icaballero.springboot.form.app.editors.RolesEditor;
import com.icaballero.springboot.form.app.models.domain.Pais;
import com.icaballero.springboot.form.app.models.domain.Role;
import com.icaballero.springboot.form.app.models.domain.Usuario;
import com.icaballero.springboot.form.app.services.PaisService;
import com.icaballero.springboot.form.app.services.RoleService;
import com.icaballero.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private PaisService paisService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PaisPropertyEditors paisPropertyEditor;
	
	@Autowired
	private RolesEditor roleEditor;

	/**
	 * Registrar el validador
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(validador);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));

		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditors());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditors());

		binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);

	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ismael");
		usuario.setApellido("Caballero");
		usuario.setIdentificador("23.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algun valor secreto");

		model.addAttribute("titulo", "Formulario Usuarios");
		model.addAttribute("usuario", usuario);

		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus session,
			@RequestParam(name = "username") String username, @RequestParam String password,
			@RequestParam String email) {

		// validator
		validador.validate(usuario, result);

		

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Resultado Form");

//			Map<String,String> errores = new HashMap<>();
//			
//					result.getFieldErrors().forEach(
//							err -> {
//								errores.put(err.getField(), "El campo "
//										.concat(err.getField()
//										.concat(" ")
//										.concat(err.getDefaultMessage())));
//							});
//					
//					model.addAttribute("error", errores);

			return "form";
		}


		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario" , required= false) Usuario usuario , Model model, SessionStatus session) {
		
		if(usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Resultado Form");
		
		session.setComplete();
		return "resultado";
	}
	

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {

//		return Arrays.asList(
//			new Pais(1,"ES"	,"España"),
//			new Pais(2, "MX", "Mexico")	,
//			new Pais(3, "CL", "chile")	,
//			new Pais(4, "AR", "Argentina"),
//			new Pais(5, "PE", "Peru"),
//			new Pais(6, "CO", "Colombia"),
//			new Pais(7, "VE", "Venezuela"));

		return paisService.listar();

	}

	@ModelAttribute("paises")
	public List<String> paises() {

		return Arrays.asList("España", "Mexico", "chile", "Argentina", "Peru", "Colombia", "Venezuela");

	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {

		Map<String, String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("CL", "Chile");
		paises.put("AR", "Argentina");
		paises.put("PE", "Perú");
		paises.put("CO", "Colombia");
		paises.put("VE", "Venezuela");

		return paises;

	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString() {

		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");

		return roles;

	}

	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {

		Map<String, String> roles = new HashMap<>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");

		return roles;

	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles () {

		return roleService.listar();

	}
	@ModelAttribute("genero")
	public List<String> listaGeneroString() {
		return Arrays.asList("Hombre","Mujer");
		
	}

}
