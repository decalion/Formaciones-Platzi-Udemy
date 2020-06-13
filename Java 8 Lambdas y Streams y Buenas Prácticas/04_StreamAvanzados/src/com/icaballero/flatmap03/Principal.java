package com.icaballero.flatmap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

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
		
		lista = Arrays.asList(p1,p2,p3,p4,p5,p6);
		
		
		//lista.stream().map(Persona::getNombre).forEach(System.out::println);
		
		//Ejemplo de flatmap para obtener los deportes
		lista.
		stream().
		//Es la operacion que a plana las listas internas de deportes y las conviertes en un 
		//flujo de elementos stream unico
		flatMap( (p)->p.getDeportes().stream()).
		map(d->d.getNombre()).
		forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		
		
		
		
		
		
		

	}
	
	

	

}
