package com.icaballero.collection02;

import java.util.ArrayList;
import java.util.Collection;

public class Principal {

	public static void main(String[] args) {

		/**
		 * La interfaz Collection hereda de Iterable
		 */

		Collection<String> lista = new ArrayList<String>();
		// Añadir datos
		lista.add("Hola");
		lista.add("que");
		lista.add("tal");

		// Comprobar si contiene un elemento
		System.out.println(lista.contains("tal"));

		// Duplicamos la lista
		lista.addAll(lista);

		// Tamaño de la lista
		System.out.println(lista.size());

		for (String cadena : lista) {

			System.out.println(cadena);
		}

		// Comprobar si la lista esta vacia
		System.out.println(lista.isEmpty());

		// Vaciamos la lista
		// lista.clear();

		System.out.println(lista.isEmpty());

		//Eliminar la palabra que solo la 1
		lista.remove("que");

		for (String cadena : lista) {

			System.out.println(cadena);
		}

	}

}
