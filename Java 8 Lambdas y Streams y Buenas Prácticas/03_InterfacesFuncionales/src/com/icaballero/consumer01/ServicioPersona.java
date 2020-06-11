package com.icaballero.consumer01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ServicioPersona {

	
	
	public List<Persona> buscarTodos(){
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();

		listaPersona.add(new Persona("pedro", "gomez", 30));
		listaPersona.add(new Persona("ana", "sancherz", 50));
		listaPersona.add(new Persona("gema", "blanco", 20));
		listaPersona.add(new Persona("david", "alvarez", 70));
		
		return listaPersona; 
		
	}
	
	
	public List<Persona> buscarTodosJubilados(){
		
		List<Persona> listaPersona = buscarTodos();
		
		Stream<Persona> miStream=listaPersona.stream().filter(Persona::estaJubilado);

	
		return miStream.collect(Collectors.toList());
		
	}
	
}
