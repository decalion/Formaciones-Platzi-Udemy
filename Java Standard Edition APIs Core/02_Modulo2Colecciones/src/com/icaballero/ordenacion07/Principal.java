package com.icaballero.ordenacion07;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



public class Principal {

	public static void main(String[] args) {

		/**
		 * Para ordenadar objetos utilizamos la interfaz comparable
		 * 
		 */
		
		//HasSetes un conjunto sin ordenar
		Set<String> conjunto = new TreeSet<String>();
		
		//Olvidar de que salga en el mismo orden insertado
		conjunto.add("hola");
		conjunto.add("que");
		conjunto.add("tal");
		conjunto.add("estas");
		conjunto.add("amigo");
		
		
		for (String texto : conjunto) {
			
			System.out.println(texto);
			
		}
		
		
		Set<Persona> conjunto2 = new TreeSet<Persona>();

		Persona p1 = new Persona("pepe", "perez", "madrid");
		Persona p2 = new Persona("ana", "gomez", "barcelona");
		Persona p3 = new Persona("juan", "sanchez", "bilbao");
		
		conjunto2.add(p1);
		conjunto2.add(p2);
		conjunto2.add(p3);
		
		for (Persona p : conjunto2) {
			System.out.println(p);
		}
	}

}
