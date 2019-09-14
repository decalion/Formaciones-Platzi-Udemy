package com.icaballero.outputstream09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * 
		 * Ejemplo de OutputStream
		 * 
		 */
		
	
		int dato;
		
		try(InputStream entrada = new FileInputStream(Paths.get("xenoblade_chronicles2.png").toFile());
				OutputStream salida = new FileOutputStream(Paths.get("xenoblade_chronicles2_2.png").toFile());
				){

			//Leemos byte a byte y lo escribimos en un fichero(Copiamos la imagen)
			
			while((dato=entrada.read())!=-1) {
				
				salida.write(dato);
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
