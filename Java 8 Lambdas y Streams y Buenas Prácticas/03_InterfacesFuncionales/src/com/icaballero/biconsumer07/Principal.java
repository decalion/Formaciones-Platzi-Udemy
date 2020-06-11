package com.icaballero.biconsumer07;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;
import com.icaballero.interfazfsupplier05.ServicioFirma;

public class Principal {

	public static void main(String[] args) {

		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();

	
		//Ejemplo de BiConsumer
		
//		BiConsumer<Persona,Persona> biConsumidor = 
//				(Persona p1, Persona p2) -> System.out.println(p1.getNombre()+","+ p2.getNombre());
//		
//		biConsumidor.accept(new Persona("pepe", "perez", 20), new Persona("ana", "gomez", 30));
//		
		
		//Guardar clave valor en un mapa
		Map<String,Persona> mapa = 
				lista.stream().
				collect(Collectors.toMap(Persona::getNombre,persona->persona));
		
		//Estamos asociando un biconsumer que es una funcion que recibe 2 parametros y no devurlve nada
		mapa.forEach(Principal::imprimirMapaPersona);
		

		}
	
	
	
	//BiConsumer
	//Funcion que recibne 2 parametros y no devurlve nada
	public static void imprimirMapaPersona(String clave, Persona persona) {
		
		System.out.printf("El nombre es %s y el apellido es %s %n",clave,persona.getApellido());
	}
	

}
