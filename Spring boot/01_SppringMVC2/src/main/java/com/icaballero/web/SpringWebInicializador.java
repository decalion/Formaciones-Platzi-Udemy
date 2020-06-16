package com.icaballero.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.icaballero.servicios.SpringConfigurador;

public class SpringWebInicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//registro un contexto via web dentro de spring framework
		AnnotationConfigWebApplicationContext contexto= new AnnotationConfigWebApplicationContext();
		contexto.register(SpringConfigurador.class);
		contexto.setServletContext(servletContext);
		
		//un servlet que haga de controlador frontal y despache todas las peticiones hacia las vistas y
		//controladores
		
		ServletRegistration.Dynamic servlet= servletContext.addServlet("dispacher", new DispatcherServlet(contexto));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
