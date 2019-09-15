package com.icaballero.sentenciascontrol04;

public class SentenciasControl2 {
	
	public static void main(String[] args) {
		
		/**
		 * Operarores logicos
		 * 
		 * && = and
		 * || = or
		 * 
		 */
		
		int numero=5;
		
		if(numero>=5 && numero < 7) {
			System.out.println("Has aprobado");
		}
		if(numero==0 || numero==10) {
			System.out.println("estas en el extremo de la nota");
		}
		
	}

}
