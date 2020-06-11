package com.icaballero.interfazfunction04;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;



public class Principal {

	
	public static void main(String[] args) {
		
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
		
		//Ejemplo de interfaz function
		//La primera parte usa un function y la segunda parte un consumer
		//La funcion transforma y el consumer finaliza
		lista.stream().map( (p) -> p.getNombre() ).forEach(System.out::println);
		
		
		//EJEMPLO2
		Function<Persona, String> mapeo = (p) -> p.getNombre();
		System.out.println();
		lista.stream().map(mapeo).forEach(System.out::println);
	}
	
	
	
	//Puede ser asociado auna funcionon consumer (Recibe la persona y no devuelve nada)
	public static void imprimirApellidos(Persona persona) {
		
		System.out.println(persona.getApellido());
	}
	
	
	
	public static void imprimirNombre(Persona persona) {
		
		System.out.println(persona.getNombre());
	}

	
	
	
	
	

}
