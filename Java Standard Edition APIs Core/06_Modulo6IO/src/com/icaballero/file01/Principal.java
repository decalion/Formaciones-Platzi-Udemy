package com.icaballero.file01;

import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo para crear un fichero
		 */
		
		File miFichero = new File("mifichero.txt");
		
		try {
			
			//Crear un fichero
			miFichero.createNewFile();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
