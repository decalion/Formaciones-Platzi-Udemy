package com.icaballero.directorios04;

import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de listar el contenido de una carperta
		 * 
		 */
		
		
		File miCarpeta= new File("micarpeta");
		
		//Guardamos el contenido de la carpeta en un array
		File[] ficheros= miCarpeta.listFiles();
		
		
		for (int i = 0; i < ficheros.length; i++) {
			
			System.out.println(ficheros[i].getName());
			
		}
		
		
	}

}
