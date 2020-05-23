package com.icaballero.filtros03;

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
		
		//Añadimos un filtro para que muestre solo las personas de edad mayor a 20
		miStream
		//.filter( (Persona p) ->p.getEdad()>20 )
		//.filter( p->p.getEdad()>20 )
		.filter(Persona::estaJubilado)
		.forEach(Principal2::imprimir);


	}
	
	public static void imprimir(Persona p) {
		
		System.out.println("**************");
		System.out.println(p.getNombre());
		System.out.println("**************");
	}

}
