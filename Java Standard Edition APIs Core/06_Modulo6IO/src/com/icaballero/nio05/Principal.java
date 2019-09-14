package com.icaballero.nio05;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * Uso de NIO a partir de Java8
		 * 
		 * Path, Paths y Files
		 */
		
		//Obtenemos el fichero de la ruta
		Path ruta = Paths.get("mifichero.txt");
		
		
		
		
		//Nombre Fichero
		System.out.println(ruta.getFileName());
		
		//Ruta absoluta
		System.out.println(ruta.toAbsolutePath());
		
		
		System.out.println();
		
		//Obtenemos todo el contenido de la ruta absoluta del fichero
		Path ruta2 = ruta.toAbsolutePath();
		
		for (Path miruta : ruta2) {
			
			System.out.println(miruta);
			
		}
		
		
		
		
	}

}
