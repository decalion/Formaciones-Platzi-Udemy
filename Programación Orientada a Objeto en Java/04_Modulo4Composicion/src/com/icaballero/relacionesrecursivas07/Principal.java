package com.icaballero.relacionesrecursivas07;

public class Principal {
	
	public static void main(String[] args) {
		/**
		 * Ejemplo de Relacion Recursiva
		 * 
		 * Una persona tiene x amigos(Personas)
		 * 
		 * La clase persona se relaciona entre ella misma 1 a N
		 * 
		 * 
		 */
		
		Persona carlos = new Persona("Carlos");
		Persona gema = new Persona("Gema");
		Persona miguel = new Persona("Miguel");
		
		miguel.addAmigo(gema);
		miguel.addAmigo(carlos);
		
		
		for (Persona p : miguel.getAmigos()) {
			
			System.out.println(p.getNombre());
			
		}
		
		
		
		
	}

}
