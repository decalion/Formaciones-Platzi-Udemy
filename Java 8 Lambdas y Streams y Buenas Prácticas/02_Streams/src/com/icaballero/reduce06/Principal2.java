package com.icaballero.reduce06;

import java.util.ArrayList;
import java.util.OptionalInt;
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
		int resultado = miStream
		.mapToInt( (Persona p) ->p.getEdad())
		//No hace falta recorrer porque el reduce ya devuelve un valor
		.reduce(0,(edad1, edad2)-> edad1+edad2);
		
		System.out.println(resultado);
		
		//Ejemplo con optional
//		OptionalInt resultado2 = miStream
//				.mapToInt( (Persona p) ->p.getEdad())
//				.reduce((edad1, edad2)-> edad1+edad2);
//		
//		
//		System.out.println(resultado2.getAsInt());
//	


	}
	

	
	public static void imprimir(int texto) {
		
		System.out.println("**************");
		System.out.println(texto);
		System.out.println("**************");
	}

}
