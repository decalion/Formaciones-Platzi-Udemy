package com.icaballero.arraylist04;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		
		ArrayList<String> miLista = new ArrayList<String>();
		
		miLista.add("Hola");
		miLista.add("Que");
		miLista.add("Tal");
		miLista.add("Estas");
		
		for (int i = 0; i < miLista.size(); i++) {
			
			System.out.println(miLista.get(i));
			
		}
		
		for (String cadena : miLista) {
			
			System.out.println(cadena);
		}
		
		boolean  miVariable = miLista.contains("Hola");
		
		System.out.println(miVariable);
		
		
		

	}

}
