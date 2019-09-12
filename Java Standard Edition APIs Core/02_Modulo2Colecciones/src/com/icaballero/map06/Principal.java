package com.icaballero.map06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {

			/**
			 * Los mapas funcionan con clave valor
			 * 
			 * La interfaz map tiene 2 implementaciones
			 * 
			 * HashMap , TreeMap
			 * 
			 * 
			 */
		
		
		Map<String,String> diccionario = new HashMap<String,String>();
		diccionario.put("nombre", "ismael");
		diccionario.put("apellidos", "Caballero");
		diccionario.put("ciudad", "Barcelona");
		
		System.out.println(diccionario.get("nombre"));
		
		
		Persona p1 = new Persona("pepe", "perez", "madrid");
		Persona p2 = new Persona("ana", "gomez", "barcelona");
		Persona p3 = new Persona("juan", "sanchez", "bilbao");
		
		Map<String,Persona> diccionarioPersona = new HashMap<String,Persona>();
		
		diccionarioPersona.put("pepe", p1);
		diccionarioPersona.put("ana", p2);
		diccionarioPersona.put("juan", p3);
		
		
		
		Persona p4 = diccionarioPersona.get("pepe");
		System.out.println(p4.getApellidos());
		
		
		//Obtenemos el conjunto de claves
		Set<String> claves =diccionarioPersona.keySet();
		
		for (String clave : claves) {
			//Sobreescribiendo el metodo toString
			System.out.println(diccionarioPersona.get(clave));
			
			System.out.println(diccionarioPersona.get(clave).getNombre());
			
		}
		
		

	}

}
