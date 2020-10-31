package ccom.icaballero.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ccom.icaballero.app.entity.Producto;
import ccom.icaballero.app.service.DummyService;

@Controller
public class MainController {

	@Autowired
	private DummyService service;
	
	@GetMapping({"/", "/welcome"})
	public String welcome(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", nombre);
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", new Date());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores		
		model.addAttribute("producto2", service.getProductoSinAlgunosValores());
		
		return "index";
	}
	
	@GetMapping("/producto/{id}")
	public String verProducto(Model model) {
		Producto producto = new Producto("Camiseta oficial de Openwebinars","¡No puedes dejar de tenerla! Se trata de la camiseta oficial de Openwebinars. Aquella que usan todos los programadores que han aprendido cualquier lenguaje de programación con alguno de nuestros cursos. ¿Te vas a quedar sin ella? Será la moda esta temporada :)",15.0f, 87, 91.1f);
		model.addAttribute("producto", producto);
		return "producto";
	}

}
