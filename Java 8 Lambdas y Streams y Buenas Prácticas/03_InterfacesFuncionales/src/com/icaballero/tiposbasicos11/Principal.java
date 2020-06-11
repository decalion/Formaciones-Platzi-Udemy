package com.icaballero.tiposbasicos11;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;

public class Principal {

	public static void main(String[] args) {
		
		
		//Gestionar un stream de numeros
		IntStream mistream = IntStream.range(1, 10);
		
		//mistream.map((n)->n*n).forEach(System.out::println);
		
	
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
		int total = lista.stream().map(Persona::getEdad).reduce(0, (a,b)-> a+b);
		
		//Optional de tripos  basicos
		OptionalInt total2 = lista.stream().mapToInt(Persona::getEdad).reduce(Integer::sum);
		
		System.out.println(total);
		
		if(total2.isPresent()) {
			System.out.println(total2.getAsInt());
		}
		
		
		//Ejemplo 2 optional
		lista.stream().
		mapToInt(Persona::getEdad).
		reduce(Integer::sum).
		ifPresent(System.out::println);
		
		
		

		}
	
	



}
