package com.icaballero.collectors07;

import java.util.List;

import com.icaballero.stream01.Persona;

public class Principal3 {

	public static void main(String[] args) {				
		//Ejemplo con collectors
		
		ServicioPersona servicio = new ServicioPersona();
		//List<Persona> lista = servicio.buscarTodos();
		List<Persona> lista = servicio.buscarTodosJubilados();
		
		
		for (Persona p : lista) {
			System.out.println(p);
		}
		
	}
	

	

}
