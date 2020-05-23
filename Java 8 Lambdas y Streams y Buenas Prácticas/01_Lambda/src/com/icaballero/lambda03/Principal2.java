package com.icaballero.lambda03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.icaballero.ejemplo01.Persona;

public class Principal2 {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(new Persona("pedro","gomez",30));
		listaPersona.add(new Persona("ana","sancherz",50));
		listaPersona.add(new Persona("gema","blanco",20));
		
		//Ordenar la lista
		//listaPersona.sort(new ComparadorNombre());
		
		//Expression lamba (parametros) -> {ejecutar}
		listaPersona.sort((Persona p1, Persona p2) -> {
				
				if(p1.getEdad() == p2.getEdad()) {
					return 0;
				}else if(p1.getEdad() > p2.getEdad()) {
					return 1;
				}else {
					return-1;
				}
				
			});
		
		for (Persona p : listaPersona) {
			
			System.out.printf("Persona: %s %s %s %n",p.getNombre(),p.getApellido(),p.getEdad());
			
		}
	}

}
