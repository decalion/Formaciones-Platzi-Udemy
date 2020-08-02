package com.icaballero.app.controllers;






import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.icaballero.app.models.Empleado;
import com.icaballero.app.services.EmpleadoServiceMemory;
import com.icaballero.app.upload.storage.StorageService;

import javax.validation.Valid;

@Controller
public class EmpleadoController {
	

	@Autowired
	public EmpleadoServiceMemory servicio;
	
	@Autowired
	private StorageService storageService;

	@GetMapping({ "/", "/empleado/list" })
	public String listado(Model model) {
		model.addAttribute("listaEmpleados", servicio.findAll());
		return "list";
	}

	@GetMapping("/empleado/new")
	public String nuevoEmpleadoForm(Model model) {
		model.addAttribute("empleadoForm", new Empleado());
		return "form";
	}

	@PostMapping("/empleado/new/submit")
	public String nuevoEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {			
			return "form";	
			
		} else {
			if (!file.isEmpty()) {
				String avatar = storageService.store(file, nuevoEmpleado.getId());
				nuevoEmpleado.setImagen(MvcUriComponentsBuilder
						.fromMethodName(EmpleadoController.class, "serveFile", avatar).build().toUriString());
			}
			servicio.add(nuevoEmpleado);
			return "redirect:/empleado/list";
		}

	}

	@GetMapping("/empleado/edit/{id}")
	public String editarEmpleadoForm(@PathVariable long id, Model model) {

		Empleado empleado = servicio.findById(id);
		if (empleado != null) {
			model.addAttribute("empleadoForm", empleado);
			return "form";
		} else {
			return "redirect:/empleado/new";
		}

	}

	@PostMapping("/empleado/edit/submit")
	public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleado,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		} else {
			servicio.edit(empleado);
			return "redirect:/empleado/list";
		}
	}
	
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}
	

}