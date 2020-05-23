package com.icaballero.lambda03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.icaballero.ejemplo01.Persona;

public class Principal3 {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(new Persona("pedro","gomez",30));
		listaPersona.add(new Persona("ana","sancherz",50));
		listaPersona.add(new Persona("gema","blanco",20));
		
		
		//Expression lamba (parametros) -> {ejecutar}
		//Simplificar expression lamba
		//Expresion lambda sencilla o compacta
		
		listaPersona.sort((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()));

		
		for (Persona p : listaPersona) {
			
			System.out.printf("Persona: %s %s %s %n",p.getNombre(),p.getApellido(),p.getEdad());
			
		}
	}

}
