package com.icaballero.ejemplo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(new Persona("pedro","gomez",30));
		listaPersona.add(new Persona("ana","sancherz",50));
		listaPersona.add(new Persona("gema","blanco",20));
		
		//Ordenar la lista
		Collections.sort(listaPersona);
		
		for (Persona p : listaPersona) {
			
			System.out.printf("Persona: %s %s %s %n",p.getNombre(),p.getApellido(),p.getEdad());
			
		}
	}

}
