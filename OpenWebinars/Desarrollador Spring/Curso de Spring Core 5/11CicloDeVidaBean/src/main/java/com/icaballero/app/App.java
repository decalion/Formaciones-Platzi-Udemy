package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icaballero.app.beans.PersonaDAO;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");


		
		PersonaDAO personaDAO = appContext.getBean(PersonaDAO.class);
		
		personaDAO.findAll().forEach(System.out::println);
		
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
