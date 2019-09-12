package com.icaballero.listas03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		/**
		 * La interfaz List hereda de Collection
		 */

		List<String> lista = new ArrayList<String>();
		lista.add("Hola");
		lista.add("que");
		lista.add("tal");
		
		//Buscar por posicion
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));

		//Obtener el indice de un elemento
		System.out.println(lista.indexOf("Hola"));
		
		//Modificar un elemento por posicion
		lista.set(0, "adios");
		System.out.println(lista.get(0));
		
		
		
	}

}
