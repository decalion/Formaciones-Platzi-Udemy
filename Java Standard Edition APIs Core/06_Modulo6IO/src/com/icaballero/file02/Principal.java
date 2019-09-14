package com.icaballero.file02;

import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de metodos de la clase file
		 */
		
		File miFichero = new File("mifichero.txt");
		
		//Obtener la ruta absoluta
		System.out.println(miFichero.getAbsolutePath());
		
		//Obtener el nombre
		System.out.println(miFichero.getName());
		
		//Saber si es un directorio
		System.out.println(miFichero.isDirectory());
		

	}

}
