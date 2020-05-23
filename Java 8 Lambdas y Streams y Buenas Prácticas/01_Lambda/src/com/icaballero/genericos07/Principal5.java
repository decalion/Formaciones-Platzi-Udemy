package com.icaballero.genericos07;

import java.util.ArrayList;

import java.util.List;

import com.icaballero.ejemplo01.Persona;


public class Principal5 {

	public static void main(String[] args) {
		
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		
		listaPersona.add(new Persona("pedro","gomez",30));
		listaPersona.add(new Persona("ana","sancherz",50));
		listaPersona.add(new Persona("gema","blanco",20));
		listaPersona.add(new Persona("antonio","perez",70));
		
		
		//Expression lamba (parametros) -> {ejecutar}
		//Simplificar expression lamba
		//Expresion lambda sencilla o compacta
		
		listaPersona.sort((p1,p2) -> p1.getNombre().compareTo(p2.getNombre()));

	
		Filtro<Persona> filtroPedro = new FiltroPersonaNombre("pedro");
		Filtro<Persona> filtroPerezOrPedro = filtroPedro.or(Persona::estaJubilado);
		
	
		//Metodo de referencia
		List<Persona> nueva = buscarPersonaPorFiltro(filtroPerezOrPedro, listaPersona);
		
		
		
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
	
	public static List<Persona> buscarPersonaPorFiltro(Filtro filtro,List<Persona> lista){
		List<Persona> listFiltro=new ArrayList<Persona>();
		
		for (Persona persona : lista ) {
			
			if(filtro.test(persona)) {
				
				listFiltro.add(persona);
			}
			
		}
		
		
		return listFiltro;
	}
	
	
	
	
}
