package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	
	public static void main(String[] args) {
		
		
		//Definir donde estan los bean mdiante xml Carpeta Resource
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		
		//Cerrar
		((ClassPathXmlApplicationContext) appContext).close();
		
		
	}

}
