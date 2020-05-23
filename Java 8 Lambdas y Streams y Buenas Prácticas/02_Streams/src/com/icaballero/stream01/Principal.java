package com.icaballero.stream01;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();

		listaPersona.add(new Persona("pedro", "gomez", 30));
		listaPersona.add(new Persona("ana", "sancherz", 50));
		listaPersona.add(new Persona("gema", "blanco", 20));
		
		//Ejemplo de stream
		Stream<Persona> miStream=listaPersona.stream();
		
		//Recorrer un stream
		miStream.forEach( (Persona p) -> System.out.println(p.getNombre()) );

	}

}
