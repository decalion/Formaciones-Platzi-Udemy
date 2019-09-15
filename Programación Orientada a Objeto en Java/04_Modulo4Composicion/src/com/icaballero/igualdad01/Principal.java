package com.icaballero.igualdad01;

public class Principal {

	public static void main(String[] args) {
		
		Persona p = new Persona("Juan");
		Persona p1 = new Persona("Juan");
		
		System.out.println(p.getNombre());
		System.out.println(p1.getNombre());

		System.out.println(p.equals(p1));
		
		System.out.println(p);
		System.out.println(p1);
	}

}
