package com.icaballero.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	 } 
	
	


}
