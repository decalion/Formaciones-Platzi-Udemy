package es.ejemplo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.ejemplo.bean.Calculadora;

//Es un servlet controlado por el Spring MVC, sustituto por ejemplo de Struts
@Controller
public class CalculadoraController {

 // Aquí está la magia !! Con poner @autowired, spring inyecta automáticamente aquí nuestro bean con el servicio !!
 // No hay que preocuparse de inicializarlo ni gestionarlo ni nada parecido !!
 @Autowired
 private Calculadora servicioCalculadora;
 
 @RequestMapping("calcula.do")
 public ModelAndView calcula(HttpServletRequest request, HttpServletResponse response) throws IOException {
  // Devolvemos la suma gracias al servicio mágico que hemos definido en el applicationContext.xml:)
  //response.getOutputStream().println("El resultado de la llamada al servicio es : " + servicioCalculadora.sumar(23, 66));
  int res = servicioCalculadora.sumar(23, 66);
  
  ModelAndView mv= new ModelAndView();
  //ModelAndView mv= new ModelAndView("vista");
  mv.addObject("res",res);
  mv.setViewName("vista");
  
  return mv;
  
  //return new ModelAndView("vista","res",res);
 
 }
}