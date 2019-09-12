package com.icaballero.wilcard05;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Persona p = new Persona();
		p.setNombre("pepe");
		Ingeniero i = new Ingeniero();
		i.setNombre("ana");

		andar(p);
		andar(i);
		System.out.println();
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(p);
		lista.add(i);
		
		andarTodas(lista);
		
		
		List<Ingeniero> lista2 = new ArrayList<Ingeniero>();
		lista2.add(i);
		//No compila porque espera una lista de personas y no una de ingenieros
		//andarTodas(lista2);
		
		System.out.println();
		andarTodasIngenieros(lista2);
		
		System.out.println();
		
		//Forma correcta
		andarTodas2(lista2);
		andarTodas2(lista);
		
	}
	
	
	public static void andarTodas(List<Persona> milista) {
		
		for (Persona p : milista) {
			p.andar();
			
		}
	}
	
	//Chapuza no es la forma correcta de solucionar el problema 
	public static void andarTodasIngenieros(List<Ingeniero> milista) {
		
		for (Ingeniero p : milista) {
			p.andar();
			
		}
	}
	
	
	//Forma correcta
	//Ahora admite listas tanto de personas como ingenieros como deportistas
	public static void andarTodas2(List<? extends Persona> milista) {
		
		for (Persona p : milista) {
			p.andar();
			
		}
	}
	
	
	
	
	public static void andar(Persona persona) {
		persona.andar();
	}
	

}
