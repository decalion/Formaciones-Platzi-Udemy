package com.icaballero.streams07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * Uso de NIO a partir de Java8
		 * 
		 * Path, Paths y Files
		 * 
		 * Uso de streams
		 */
		
		
		
		Path ruta = Paths.get("micarpeta");
		
		try {
			
			/**
			 * Obtenemos el fichero otro1 y otro2 en mayusculas
			 */
			
			Stream<Path> st=Files.list(ruta);
			
			st
			.filter((p)->p.getFileName().toString().contains("otro"))
			.map((p)->p.getFileName().toString().toUpperCase())
			.forEach(System.out::println);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

}
