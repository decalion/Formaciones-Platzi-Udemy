package com.icaballero.gzstream12;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;

public class Principal {

	public static void main(String[] args) {

		/**
		 * 
		 * Ejemplo de GZSTREAM para comprimir un fichero
		 * 
		 * 1. solicitamos escribir a fichero con  FileOutputStream
		 * 2. Comprimimos la operacion GZIPOutputStream
		 * 3. cacheamos la operacion con BufferedOutputStream
		 * 4. convertir de binario a texto
		 * 5. El bufferwriter que se apoya en el transformador
		 * 
		 */

		try (
				FileOutputStream salida = new FileOutputStream(Paths.get("texto3.txt").toFile());
				GZIPOutputStream salidaComprimida = new GZIPOutputStream(salida);
				BufferedOutputStream salidaCache = new BufferedOutputStream(salidaComprimida);
				OutputStreamWriter transformador = new OutputStreamWriter(salidaCache);
				BufferedWriter escritorTexto = new BufferedWriter(transformador);

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
