package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2 {
	
	
	public static void main(String[] args) {
		
		
		//Definir donde estan los bean mdiante xml en el file system
		ApplicationContext appContext = new FileSystemXmlApplicationContext("beans2.xml");
		
		
		
		//Cerrar
		((FileSystemXmlApplicationContext) appContext).close();
		
		
	}

}
