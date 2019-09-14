package com.icaballero.writers11;


import java.io.BufferedWriter;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {

		/**
		 * 
		 * Ejemplo de Writters para escribir en un fichero
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		try (FileWriter salida = new FileWriter(Paths.get("texto2.txt").toFile());
				BufferedWriter escritorTexto = new BufferedWriter(salida);

		) {

			for (int i = 0; i < 1000; i++) {
				escritorTexto.write("Hola esto es un texto " + i);
				escritorTexto.newLine();

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
