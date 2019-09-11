package com.icaballero.strings05;



public class Principal {

	public static void main(String[] args) {
	
		//Strings
		
		String cadena = "Hola que tal";
		
		//Longitud de la cadena
		System.out.println(cadena.length());
		
		//Recorrer letra por letra
		for (int i = 0; i < cadena.length(); i++) {
			
			System.out.println(cadena.charAt(i));
		}
		
		System.out.println(cadena.toUpperCase());
		
		String cadena2="   Hola que tal   ";
		//Quitar los espacios
		System.out.println(cadena2);
		System.out.println(cadena2.trim());
		
		//Concatenar cadenas
		String cadena3 = "Hola";
		String cadena4 = cadena2.concat(cadena3);
		System.out.println(cadena4);
		
		//Substrings
		String subcadena = cadena2.substring(1,5);
		System.out.println(subcadena);
		
		
			
	}
	

}
