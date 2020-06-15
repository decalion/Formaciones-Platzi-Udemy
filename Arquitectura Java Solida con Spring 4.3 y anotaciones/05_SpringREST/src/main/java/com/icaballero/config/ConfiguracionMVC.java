package com.icaballero.config;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ConfiguracionMVC extends WebMvcConfigurerAdapter  implements ApplicationContextAware {

	  

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
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(contexto);
		resolver.setPrefix("/WEB-INF/vistas/");
		resolver.setSuffix(".html");

		resolver.setCacheable(false);
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

	public void setApplicationContext(ApplicationContext contexto) throws BeansException {
		this.contexto= contexto;
		
		
		
	}
	


	public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
	    MappingJackson2HttpMessageConverter messageConverter = new  MappingJackson2HttpMessageConverter();

	    ObjectMapper mapper = new ObjectMapper();
	    
	    mapper.registerModule(new Hibernate5Module());

	    messageConverter.setObjectMapper(mapper);
	    return messageConverter;

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    //Here we add our custom-configured HttpMessageConverter
	    converters.add(jacksonMessageConverter());
	    super.configureMessageConverters(converters);
	}

	
}
