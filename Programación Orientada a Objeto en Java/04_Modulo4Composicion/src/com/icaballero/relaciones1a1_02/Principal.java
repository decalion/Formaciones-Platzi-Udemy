package com.icaballero.relaciones1a1_02;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de relacion 1 a 1
		 * 
		 * Un sobre puede contener 1 galleta
		 * 
		 */
		
		Galleta g1 = new Galleta("Chocolate", 1);
		
		System.out.println(g1.getSabor());
		
		Sobre s1 = new Sobre();
		s1.setColor("Azul");
		s1.setGalleta(g1);
		
		System.out.println(s1.getColor());
		System.out.println(s1.getGalleta().getSabor());
		System.out.println(s1.getGalleta().getPrecio());

	}

}
