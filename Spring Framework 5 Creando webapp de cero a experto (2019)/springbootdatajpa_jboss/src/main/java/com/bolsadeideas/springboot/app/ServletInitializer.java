package com.bolsadeideas.springboot.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase para desplegar en un tomcat externo
 * @author ismael
 *
 */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		//Hay que pasar la clase principal de spring
		return builder.sources(SpringbootdatajpaApplication.class);
	}
	
	
	
	

}
