package com.icaballero.directorios03;

import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de crear un directorio y un fichero dentro de la carpeta
		 */
		
		/*
		File miFichero = new File("micarpeta");
		
		//Crear un directorio
		miFichero.mkdir();
	
		*/
		
		//Crear un fichero dentro de la carpeta
		File miFichero = new File("micarpeta","otro2.txt");
		try {
			
			miFichero.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
