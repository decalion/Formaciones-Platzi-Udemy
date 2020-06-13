package com.icaballero.minmax02;

import java.util.List;
import java.util.OptionalInt;

import com.icaballero.slicing01.Persona;
import com.icaballero.slicing01.ServicioPersona;




public class Principal {

	
	public static void main(String[] args) {
		
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
		
		
		int total = lista.stream().map(Persona::getEdad).reduce(0, (a,b)->a+b);
		int max = lista.stream().map(Persona::getEdad).reduce(0, (a,b)->a>b?a:b);
		int min = lista.stream().map(Persona::getEdad).reduce(120, (a,b)->a>b?b:a);
		System.out.println(total);
		System.out.println(max);
		System.out.println(min);
		
		
		System.out.println();
		
		
		int suma = lista.stream().mapToInt(Persona::getEdad).sum();
		long contar = lista.stream().mapToInt(Persona::getEdad).count();
		OptionalInt minimo = lista.stream().mapToInt(Persona::getEdad).min();
		OptionalInt maximo = lista.stream().mapToInt(Persona::getEdad).max();
		System.out.println(suma);
		
		if(minimo.isPresent()) {
			System.out.println(minimo.getAsInt());
		}
		
		if(maximo.isPresent()) {
			System.out.println(maximo.getAsInt());
		}
		
		System.out.println(contar);
		
		
		
		
		

	}
	
	

	

}
