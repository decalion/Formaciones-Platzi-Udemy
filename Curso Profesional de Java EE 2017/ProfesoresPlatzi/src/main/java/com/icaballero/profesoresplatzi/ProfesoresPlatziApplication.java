package com.icaballero.profesoresplatzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class ProfesoresPlatziApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfesoresPlatziApplication.class, args);
	}

}
