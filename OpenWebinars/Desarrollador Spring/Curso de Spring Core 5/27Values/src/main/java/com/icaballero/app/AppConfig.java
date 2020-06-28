package com.icaballero.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.icaballero.app")
@PropertySource("classpath:/ejemplo.properties")
public class AppConfig {

}
