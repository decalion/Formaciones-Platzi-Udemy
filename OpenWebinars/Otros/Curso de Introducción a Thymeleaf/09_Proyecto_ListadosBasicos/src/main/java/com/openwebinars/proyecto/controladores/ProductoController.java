package com.openwebinars.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openwebinars.proyecto.servicios.ProductoService;

@Controller
@RequestMapping("/admin/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "admin/list-producto";
	}


}
