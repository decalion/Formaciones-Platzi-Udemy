package com.icaballero.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Desactivar los tokens de proteccion solo para rest
		http.csrf().disable();
		
		//Permitir peticiones rest
		http.authorizeRequests()
		.antMatchers("/webapi/**")
		.permitAll();
		
		//Formulario de login
		http.authorizeRequests()
		.antMatchers("/**")
		.hasRole("BASICO")
		.and()
		.formLogin();
		
		
		
		super.configure(http);
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
		.inMemoryAuthentication()
		.withUser("ismael")
		.password("ismael")
		.roles("BASICO");
				
			
	}
	
	
	
	

}
