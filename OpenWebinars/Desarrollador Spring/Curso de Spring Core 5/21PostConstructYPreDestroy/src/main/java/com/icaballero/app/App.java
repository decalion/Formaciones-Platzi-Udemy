package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.icaballero.app.beans.PeliculaService;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		PeliculaService peliculaService = appContext.getBean(PeliculaService.class);

		peliculaService.pelisPorGenero("Ciencia ficci�n").forEach(System.out::println);

		((ClassPathXmlApplicationContext) appContext).close();
	}

}
