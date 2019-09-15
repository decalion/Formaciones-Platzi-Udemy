package com.icaballero.encapsulacion02;

public class Principal {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		p1.setEdad(1000);
		p1.setNombre("Pepito");
		System.out.println(p1.getEdad());
		System.out.println(p1.getNombre());
		
		
	}

}
