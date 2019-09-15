package com.icaballero.metodosestaticos10;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Los metodos statics son metodos de clase 
		 */
		
		Coche c1 = new Coche();
		Coche c2 = new Coche();
		Coche c3 = new Coche();
		Coche c4 = new Coche();
	
		System.out.println(Coche.getContador());
		
		


	}

}
