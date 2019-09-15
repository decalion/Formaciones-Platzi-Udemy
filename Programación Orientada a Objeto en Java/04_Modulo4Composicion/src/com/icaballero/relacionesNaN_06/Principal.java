package com.icaballero.relacionesNaN_06;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de relacion N a N
		 * 
		 * En una casa viven muchas personas y muchas personas viven en una casa
		 * 
		 */
		
		Casa c = new Casa("Santander");
		Persona p = new Persona("Juan");
		Persona p1 = new Persona("Ana");
		
		c.add(p);
		c.add(p1);
		
		System.out.println(c.contains(new Persona("Juan")));
		System.out.println(c.contains(new Persona("Ana")));
		System.out.println(c.totalPersonas());
		
		p.add(c);
		System.out.println(p.contains(c));
		
		
	}
	
	
	
}
