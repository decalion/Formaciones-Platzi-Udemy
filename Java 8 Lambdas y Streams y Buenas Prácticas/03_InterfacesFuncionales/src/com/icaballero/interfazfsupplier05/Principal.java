package com.icaballero.interfazfsupplier05;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;



public class Principal {

	
	public static void main(String[] args) {
		
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
	
		//Ejemplo supplier
		//Un supplier devuelve un objeto y no recibe nada como paarametro
		Supplier<Persona> obtenerPersona = () ->new Persona("juan","gomez",20);
		Persona p = obtenerPersona.get();
		System.out.println(p.getNombre());
		
		
		//Ejemplo2
		//Los supplier se utilizan para invocar metodos de forma repetitiva
		ServicioFirma miServicio = new ServicioFirma(p);
		
		Supplier<String> s = miServicio::obtenerFirma;
		
		System.out.println("Imprimiendo pagina 1");
		System.out.println(s.get());	
		System.out.println("Imprimiendo pagina 2");
		System.out.println(s.get());
		System.out.println("Imprimiendo pagina 3");
		System.out.println(s.get());	
		System.out.println("Imprimiendo pagina 4");
		System.out.println(s.get());
		
		
		
	}
	
	
	

	
	
	
	

}
