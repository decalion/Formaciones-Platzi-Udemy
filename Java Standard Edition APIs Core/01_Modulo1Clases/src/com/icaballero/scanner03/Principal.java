package com.icaballero.scanner03;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo Scanner
		
		System.out.println("Introduce el nombre:");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Introduce el Apellido:");
		String apellido = sc.nextLine();	
		System.out.println(nombre);
		System.out.println(apellido);
		sc.close();
			
	}
	

}
