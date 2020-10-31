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
	
	@GetMapping({"/", "/list"})
	public String list(@RequestParam(name="iterstat", required=false, defaultValue="no") String iterstat, Model model) {
		model.addAttribute("productos", service.getLista());
		if (iterstat.equalsIgnoreCase("no"))
			return "index";
		else
			return "index-stat";
	}
	
	@GetMapping({"/array"})
	public String array(Model model) {
		model.addAttribute("productos", service.getArray());		
		return "index";
	}
	
	@GetMapping({"/collection"})
	public String collection(Model model) {	
		model.addAttribute("productos", service.getCollection());		
		return "index";
	}

	@GetMapping({"/set"})
	public String set(Model model) {	
		model.addAttribute("productos", service.getSet());		
		return "index";
	}
	

	@GetMapping({"/map"})
	public String map(Model model) {	
		model.addAttribute("carrito", service.getMap());		
		return "index-map";
	}
	
	
	@GetMapping("/producto/{id}")
	public String verProducto(Model model) {
		Producto producto = new Producto("Camiseta oficial de Openwebinars","¡No puedes dejar de tenerla! Se trata de la camiseta oficial de Openwebinars. Aquella que usan todos los programadores que han aprendido cualquier lenguaje de programación con alguno de nuestros cursos. ¿Te vas a quedar sin ella? Será la moda esta temporada :)",15.0f, 87, 91.1f);
		model.addAttribute("producto", producto);
		return "producto";
	}

}
