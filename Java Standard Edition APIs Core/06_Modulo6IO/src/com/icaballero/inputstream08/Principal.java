package com.icaballero.inputstream08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * 
		 * Ejemplo de inputStream
		 * 
		 */
		
	
		int dato;
		
		try(InputStream entrada = new FileInputStream(Paths.get("xenoblade_chronicles2.png").toFile());){

			//Leemos byte a byte
			while((dato=entrada.read())!=-1) {
				
				System.out.print((char)dato);
			}
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
