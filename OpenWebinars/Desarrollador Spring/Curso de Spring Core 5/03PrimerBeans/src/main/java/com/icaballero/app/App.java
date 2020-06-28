package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icaballero.app.beans.Saludator;

public class App {
	
	
	public static void main(String[] args) {
		
		
		//Definir donde estan los bean mdiante xml
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Saludator saludador = null;
		
		// 1. getBean con ID y casting
		//saludador = (Saludator) appContext.getBean("saludator");
		
		// 2. getBean con ID y tipo
		//saludador = appContext.getBean("saludator", Saludator.class);
		
		// 3. getBean con tipo
		saludador = appContext.getBean(Saludator.class);
				
		System.out.println(saludador.saludo());
		
		//Cerrar
		((ClassPathXmlApplicationContext) appContext).close();
		
		
	}

}
