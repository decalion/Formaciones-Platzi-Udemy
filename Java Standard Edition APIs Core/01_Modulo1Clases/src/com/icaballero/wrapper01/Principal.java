package com.icaballero.wrapper01;

public class Principal {

	public static void main(String[] args) {
	
		//numero
		int numero = 7;
		
		//Objeto wrapper
		Integer mientero = new Integer(numero);
		
		
		//Con la clase warapper convertimos el numero a una cadena
		String numeroCdena = mientero.toString();
		
		
		System.out.println(numero);
		System.out.println(numeroCdena);
		
		String numero2="14";
		String numero3="25";
		
		System.out.println(numero2+numero3);
		
		//Convertimos las cadenas en numeros
		int resultado =Integer.parseInt(numero2)+Integer.parseInt(numero3);
		
		System.out.println(resultado);
	
		//Convertimos el objeto wrapper en un tipo primitivo
		int nuevoNumero = mientero.intValue()+5;
		
		System.out.println(nuevoNumero);
	
	
	}

}
