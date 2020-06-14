package com.icaballero.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icaballero.bo.Noticia;
import com.icaballero.servicios.ServicioNoticias;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	
	@Autowired
	ServicioNoticias servicio;
	
	
	@RequestMapping("/lista")
	public String lista(Model modelo) {
		
		//Envia a la lista todas las noticias
		modelo.addAttribute("noticias", servicio.findAllNoticia());
		
		return "lista";
	}
	
	@RequestMapping("/formularioNuevaNoticia")
	public String formularioNuevoNoticia(Model modelo) {
		
		modelo.addAttribute(new Noticia());
		
		return "formularioNuevaNoticia";
		
	}
	
	//Ya tenemos la noticia rellenada con los datos del  formulario
	//ModelAttribute recuperamos un atributo guardado previamente
	//Con la anotacion valid validamos la noticia, con el bindingresult comprobamos si hay errores
	@RequestMapping(value="/insertarNoticia",method=RequestMethod.POST)
	public String insertarNoticia(@Valid @ModelAttribute Noticia noticia,BindingResult validacion,Model modelo) {
		
		if(validacion.hasErrors()) {
			return "formularioNuevaNoticia";
		} else  {

		servicio.saveNoticia(noticia);
		
		modelo.addAttribute("noticias", servicio.findAllNoticia());
		
		return "lista";
		}
	}
	
	//RequestParam nos permite recibir un parametro
	@RequestMapping("/borrarNoticia")
	public String borrarNoticia(@RequestParam("titulo") String titulo, Model modelo) {
		
		servicio.deleteNoticia(new Noticia(titulo));
		
		modelo.addAttribute("noticias", servicio.findAllNoticia());
		
		
		return "lista";
	}
	
	
	
	
	
	
	

}
