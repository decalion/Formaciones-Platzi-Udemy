package com.icaballero.readers11;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {
		
		
		/**
		 * 
		 * Ejemplo de Readers para leer ficheros
		 * 
		 * Con la clase InpuStreamReader transformamos un stream binario a un stream de texto
		 * 
		 * 
		 * 
		 * 
		 */
		
	
		//int dato;
		//long numero1 = System.currentTimeMillis();
		
		String linea = null;
		
		try(InputStream entrada = new FileInputStream(Paths.get("texto.txt").toFile());
				InputStreamReader transformador = new InputStreamReader(entrada);
				BufferedReader lectorTexto = new BufferedReader(transformador);
				
				){

		
			
			while( (linea=lectorTexto.readLine()) !=null) {
				
				System.out.println(linea);
			}
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*long numero2 = System.currentTimeMillis();
		System.out.println("****************************");
		System.out.println(numero2-numero1);*/
		
	}

}
