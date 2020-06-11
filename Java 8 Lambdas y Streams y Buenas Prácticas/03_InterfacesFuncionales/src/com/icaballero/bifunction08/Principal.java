package com.icaballero.bifunction08;

import java.util.Arrays;
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

		Documento d1 = new Documento("java", 1);
		Documento d2 = new Documento("net", 1);
		Documento d3 = new Documento("python", 1);
		Documento d4 = new Documento("java", 2);
		
		List<Documento> list= Arrays.asList(d1,d2,d3,d4);
		
		//Reduccion sobre un acumulador y un bioperator
		Documento mayor = list.stream().reduce(d1, Documento::esMayor);
		
		System.out.println(mayor.getTitulo());
		System.out.println(mayor.getVersion());


		}
	
	


}
