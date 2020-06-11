package com.icaballero.interfazfpredicate06;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;
import com.icaballero.interfazfsupplier05.ServicioFirma;

public class Principal {

	public static void main(String[] args) {

		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();

		// Ejemplo predicate
		Predicate<Persona> pPersona = 
				(Persona p) -> p.getNombre().equals("pedro");
		
				//Nos muestras las personas que se llaman ana o pedro y no tienen el apellido sanchez
		Predicate<Persona> nuevo = 
				pPersona.or((p) -> p.getNombre().equals("ana"))
				.or((p) -> p.getApellido().equals("sanchez")).negate();

		
		lista.stream().filter(nuevo).map(Persona::getNombre).forEach(System.out::println);
			
		}
	

}
