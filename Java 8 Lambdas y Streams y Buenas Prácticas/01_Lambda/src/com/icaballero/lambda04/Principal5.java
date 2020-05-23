package com.icaballero.lambda04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.icaballero.ejemplo01.Persona;

public class Principal5 {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(new Persona("pedro","gomez",30));
		listaPersona.add(new Persona("ana","sancherz",50));
		listaPersona.add(new Persona("gema","blanco",20));
		
		
		//Expression lamba (parametros) -> {ejecutar}
		//Simplificar expression lamba
		//Expresion lambda sencilla o compacta
		
		listaPersona.sort((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()));

		//List<Persona> nueva = buscarPersonaPorNombre("pedro", listaPersona);
		//List<Persona> nueva = buscarPersonaPorFiltro(new FiltroPersonaNombre("pedro"), listaPersona);
		
		
		//Expression Lambda
		//List<Persona> nueva = buscarPersonaPorFiltro( (p) -> p.getApellido().contentEquals("blanco"), listaPersona);
		List<Persona> nueva = buscarPersonaPorFiltro( (p) -> p.getNombre().contentEquals("pedro"), listaPersona);
		
		
		
		for (Persona p : nueva) {
			
			System.out.printf("Persona: %s %s %s %n",p.getNombre(),p.getApellido(),p.getEdad());
			
		}
	}

	
	
	
	/************************************************
	 * 
	 * 
	 *   SE REPITE MUCHO EL CODIGO PARA HACER 2 NUSQUEDA.
	 *   CON INTERFAZ Y EXPRESSION LAMBDA SE SIMPLIFICA
	 * 
	 * 
	 **********************************************/
	
	public static List<Persona> buscarPersonaPorNombre(String nombre,List<Persona> lista){
		List<Persona> listFiltro=new ArrayList<Persona>();
		
		for (Persona persona : lista ) {
			
			if(persona.getNombre().contentEquals(nombre)) {
				
				listFiltro.add(persona);
			}
			
		}
		
		
		return listFiltro;
	}
	
	
	
	public static List<Persona> buscarPersonaPorApellifo(String apellido,List<Persona> lista){
		List<Persona> listFiltro=new ArrayList<Persona>();
		
		for (Persona persona : lista ) {
			
			if(persona.getApellido().contentEquals(apellido)) {
				
				listFiltro.add(persona);
			}
			
		}
		
		
		return listFiltro;
	}
	
	public static List<Persona> buscarPersonaPorFiltro(FiltroPersona filtro,List<Persona> lista){
		List<Persona> listFiltro=new ArrayList<Persona>();
		
		for (Persona persona : lista ) {
			
			if(filtro.test(persona)) {
				
				listFiltro.add(persona);
			}
			
		}
		
		
		return listFiltro;
	}
	
	
	
	
}
