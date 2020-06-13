package com.icaballero.anymatch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

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
		
		lista = Arrays.asList(p1,p2,p3,p4,p5,p6);
		
		
		//lista.stream().map(Persona::getNombre).forEach(System.out::println);
		
		//Ejemplo de flatmap para obtener los deportes
		boolean cumple = lista.
		stream().
		flatMap( (p)->p.getDeportes().stream()).
		//Comprobar si algun deporte es mayor a 10 horas
		anyMatch(  (d)->d.getHoras()>10  );
		
		
		System.out.println(cumple);
		
		
		System.out.println();
	
		
		
		//Ejemplo de flatmap para obtener los deportes
		boolean cumple2 = lista.
		stream().
		flatMap( (p)->p.getDeportes().stream()).
		//Comprobar si todos los deportes tienen mas de 10 horas
		allMatch(  (d)->d.getHoras()>10  );
		
		System.out.println(cumple2);
		
		System.out.println();
	
		
		
		
		//Ejemplo de flatmap para obtener los deportes
				boolean cumple3 = lista.
				stream().
				flatMap( (p)->p.getDeportes().stream()).
				//Comprobar si ningun deporte supera las 40 horas
				noneMatch(  (d)->d.getHoras()>40  );
				
				System.out.println(cumple3);
				
				
				
				System.out.println();
				
				
				//Ejemplo de flatmap para obtener los deportes
				boolean cumple4 = lista.
				stream().
				flatMap( (p)->p.getDeportes().stream()).
				peek( System.out::println).
				anyMatch(  (d)->d.getHoras()>20  );
		

	}
	
	

	

}
