package com.icaballero.defaultmethod09;

import java.util.Arrays;
import java.util.List;


import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;


public class Principal {

	public static void main(String[] args) {

		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();

		Documento d1 = new Documento("java", 1);
		Documento d2 = new Documento("net", 1);
		Documento d3 = new Documento("python", 1);
		Documento d4 = new Documento("java", 2);
		
		List<Documento> list= Arrays.asList(d1,d2,d3,d4);
		
		//Reduccion sobre un acumulador y un bioperator
		
		//Versionable.esMayor(d1, d2);
		
		d1.esMayor(d2);
		Documento mayor = list.stream().reduce(d1, Versionable::esMayor);
		
		System.out.println(mayor.getTitulo());
		System.out.println(mayor.getVersion());


		}
	
	


}
