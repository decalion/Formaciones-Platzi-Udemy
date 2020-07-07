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
	
	
	
	/**
	 * Configuración más básica. Por defecto se permite
	 * - Todos los orígnenes
	 * - Métodos GET, HEAD, POST
	 * 
	 */
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//			}
//			
//		};
//	}
	
	/**
	 * Configuración más ajustada.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/producto/**")
					.allowedOrigins("http://localhost:8080")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.maxAge(3600);
			}
			
		};
	}
	



}
