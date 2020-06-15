package com.icaballero.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.icaballero.config.ConfiguracionPersistencia;

@Configuration
@ComponentScan("com.icaballero")
@Import({ConfiguracionPersistencia.class,ConfiguracionMVC.class,ConfiguracionSeguridad.class})
public class ConfiguracionSpring  {
	
	

	
}
