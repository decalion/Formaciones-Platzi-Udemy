package com.icaballero.metodosestaticos11;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Los metodos statics son metodos de clase 
		 */
		
		
		System.out.println(Circulo.area(2));
		
		System.out.println();
		Circulo c = new Circulo(2);
		System.out.println(c.area());
		
		


	}

}
