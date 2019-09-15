package com.icaballero.composicionencapsulacion03;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de encapsulacion
		 * 
		 * Hacemos que el sobre se encargue de generar la Galleta directamente desde el constructor
		 * Asi encapsulamos la galleta
		 * 
		 * 
		 */


		Sobre s1 = new Sobre("Azul","Chocolate",1);
	
		
		System.out.println(s1.getColor());
		System.out.println(s1.getPrecio());
		System.out.println(s1.getSabor());
		

	}

}
