package com.icaballero.map05;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.icaballero.stream01.Persona;

public class Principal2 {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();

		listaPersona.add(new Persona("pedro", "gomez", 30));
		listaPersona.add(new Persona("ana", "sancherz", 50));
		listaPersona.add(new Persona("gema", "blanco", 20));
		listaPersona.add(new Persona("david", "alvarez", 70));
		
		//Ejemplo de stream
		Stream<Persona> miStream=listaPersona.stream();
		
		//
		miStream
		//El map sirve para transformar un objeto en otro tipo en 
		//este caso de persona a string
		.map( (Persona p) ->p.getNombre())
		//.forEach(System.out::println);
		.forEach(Principal2::imprimir);


	}
	
	public static void imprimir(Persona p) {
		
		System.out.println("**************");
		System.out.println(p.getNombre());
		System.out.println("**************");
	}
	
	
	public static void imprimir(String texto) {
		
		System.out.println("**************");
		System.out.println(texto);
		System.out.println("**************");
	}

}
