package com.icaballero.collectors07;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
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
		
		//miStream.filter((p)->p.getEdad()>30).forEach(System.out::println);
		
		//Ejemplo con  Collector
		List<Persona> lista=miStream
				.filter((p)->p.getEdad()>30)
				.collect(Collectors.toList());

		for (Persona p : lista) {
			System.out.println(p);
		}
	}
	

	
	public static void imprimir(int texto) {
		
		System.out.println("**************");
		System.out.println(texto);
		System.out.println("**************");
	}

}
