package com.icaballero.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.icaballero.config.ConfiguracionSpring;

public class SpringWebInicializador implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ConfiguracionSpring.class);
		//Enlazar spring con la web
		context.setServletContext(servletContext);
		
		//Genera un servler dinamicamente para nuestra aplicacion web
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new RepositoryRestDispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		//Configuracion de spring security
		servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
		.addMappingForUrlPatterns(null, false, "/*");
		
	}

}
