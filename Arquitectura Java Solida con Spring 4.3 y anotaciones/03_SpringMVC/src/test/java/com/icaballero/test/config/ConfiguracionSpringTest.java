package com.icaballero.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.icaballero.config.ConfiguracionPersistencia;

@Configuration
@ComponentScan({"com.icaballero.servicios","com.icaballero.repositorios"})
@Import({ConfiguracionPersistencia.class})
public class ConfiguracionSpringTest  {
	
	

	
}
