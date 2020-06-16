package com.icaballero.servicios;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		//Crear un contexto pasra anotaciones
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//Registrar los ficheros de configutracion
		context.register(SpringConfigurador.class);
		context.refresh();
		
		//invocar el bean
		Servicio servicio = context.getBean(Servicio.class);
		System.out.println(servicio.mensaje());
		
		context.close();

	}

}
