package com.icaballero.customcollectors07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.icaballero.flatmap04.Deporte;
import com.icaballero.flatmap04.Persona;
import com.icaballero.slicing01.ServicioPersona;




public class Principal {

	
	public static void main(String[] args) {
		
		List<Persona> lista= new ArrayList<Persona>();
		
		Persona p1 = new Persona("pedro", "gomez", 30);
		p1.addDeporte(new Deporte("padel",30));
		p1.addDeporte(new Deporte("natacion",10));
		
		Persona p2 = new Persona("ana", "sancherz", 50);
		p2.addDeporte(new Deporte("futbol",20));
		p2.addDeporte(new Deporte("tenis",8));
		
		
		Persona p3 = new Persona("gema", "blanco", 20);
		p3.addDeporte(new Deporte("pesas",20));
		p3.addDeporte(new Deporte("ciclismo",10));
		
		Persona p4 = new Persona("david", "alvarez", 70);
		p4.addDeporte(new Deporte("ciclismo",20));
		p4.addDeporte(new Deporte("padel",8));
		
		Persona p5 = new Persona("gabriel", "marquez", 50);
		p5.addDeporte(new Deporte("yoga",15));
		p5.addDeporte(new Deporte("ciclismo",10));
		
		Persona p6 = new Persona("maria", "sanchez", 20);
		p6.addDeporte(new Deporte("ciclismo",20));
		p6.addDeporte(new Deporte("padel",8));
		
		Persona p7 = new Persona("gabriel", "perez", 50);
		p7.addDeporte(new Deporte("yoga",15));
		p7.addDeporte(new Deporte("ciclismo",10));
		
		lista = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
		
		
		//Ejemplo de TreeSet
		TreeSet<Persona> nueva = lista.stream().collect(Collectors.toCollection(TreeSet::new));
	
	
		for (Persona persona : nueva) {
			
			System.out.println(persona.getNombre());
			
		}
	
	}
	
	

	

}
