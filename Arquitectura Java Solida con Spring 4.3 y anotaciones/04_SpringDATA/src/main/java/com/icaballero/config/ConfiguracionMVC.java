package com.icaballero.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
public class ConfiguracionMVC  implements ApplicationContextAware{
	private ApplicationContext contexto;
	
	@Bean
	public TemplateEngine templateEngine() {
		
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		
		return engine;
		
	}
	
	@Bean
	public ViewResolver viewResolver() {
		
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		
		return resolver;
		
	}
	
	
	private ITemplateResolver templateResolver() {
		//Este metodo resuelve donde van a estar ubicado las plantillas y que tipo de plantillas son
		
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(contexto);
		resolver.setPrefix("/WEB-INF/vistas/");
		resolver.setSuffix(".html");
		
		resolver.setCacheable(false);
		resolver.setTemplateMode(TemplateMode.HTML);
		
		return resolver;
		
		
	}
	
	//Configurar el context de la aplicacion
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.contexto = applicationContext;
		
	}
	

}
