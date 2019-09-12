package com.icaballero.set05;

import java.util.HashSet;

public class Principal {

	public static void main(String[] args) {

		/**
		 * La interfaz SET extiende collection y no admite repetidos
		 * 
		 * Hay 3 implementaciones HashSet , TreeSet , LinkedHashSet HashSet -> standar
		 * TreeSet -> ordenado LinkedHashSet -> flexible a la hora de añadir elementos
		 * 
		 * 
		 */

		HashSet<String> conjunto = new HashSet<String>();
		conjunto.add("hola");
		conjunto.add("que");
		conjunto.add("tal");
		conjunto.add("hola");

		// No sale ordenado
		for (String cadena : conjunto) {

			System.out.println(cadena);

		}

		Persona p1 = new Persona("juan");
		Persona p2 = new Persona("pedro");
		Persona p3 = new Persona("juan");
		
		HashSet<Persona> conjunto2 = new HashSet<Persona>();
		conjunto2.add(p1);
		conjunto2.add(p2);
		conjunto2.add(p3);
		for (Persona p : conjunto2) {

			System.out.println(p);

		}

	}

}
