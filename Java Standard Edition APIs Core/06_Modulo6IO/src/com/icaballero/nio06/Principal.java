package com.icaballero.nio06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * Uso de NIO a partir de Java8
		 * 
		 * Path, Paths y Files
		 */
		
		
		/**
		 * Ejemplo para copiar un fichero
		 * 
		 * La clase Files sirve para gestionar el movimiento copiado y eliminado de ficheros de disco
		 */
		
		Path ruta = Paths.get("mifichero.txt");
		Path rutaDestino=Paths.get("micarpeta/mifichero.txt");
		
		try {
			
			Files.copy(ruta, rutaDestino);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		
		
	}

}
