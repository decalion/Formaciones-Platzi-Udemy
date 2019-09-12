package com.icaballero.iterable01;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		
		//Ejemplo de Iterable e Iterator
		ArrayList<String> lista = new ArrayList();
		lista.add("Hola");
		lista.add("que");
		lista.add("tal");
		
		
		//ArrayList implementa la interfaz iterable
		//Un iterable es algo que se puede recorrer
		Iterable<String> miIterable = lista;
		
		//El iterador es el encargado de recorrer
		Iterator<String> it = miIterable.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
			//Eliminar elementos
			//it.remove();
		}

		
		//Para poder usar el foreach la clase tiene que implementar la interfaz iterable
		for (String cadena : lista) {
			System.out.println(cadena);
			
		}
		
		
		
	}

}
