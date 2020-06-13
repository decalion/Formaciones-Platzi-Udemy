package com.icaballero.slicing01;

import java.util.List;




public class Principal {

	
	public static void main(String[] args) {
		
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
		
//		lista.stream().
//		filter(p->p.getNombre().equals("ana")).
//		map(Persona::getNombre).
//		forEach(System.out::println);
		
		//El slicing nos permite saltarnos elementos.
		//En este caso se saltada 2 elementos
		
		lista.stream().skip(2).forEach(Principal::mostrarPersona);
		
		System.out.println();
		
		//En este caso decimos que se salte 1 y muestre solo 2
		lista.stream().skip(1).limit(2).forEach(Principal::mostrarPersona);

	}
	
	
	//Ejemplo de consumidor
	public static void mostrarPersona(Persona p) {
		
		System.out.println(p.getNombre());
		System.out.println(p.getApellido());
		System.out.println(p.getEdad());
	}
	
	

}
