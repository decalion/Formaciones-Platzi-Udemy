package com.icaballero.iostream06;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import com.icaballero.sorting01.Factura;





public class Principal {

	
	public static void main(String[] args) {

		
		File fichero = new File("./src");
		
		File[] ficheros = fichero.listFiles();
		
		for (File f : ficheros) {
			
			imprimir(f);
			
		}
		
		
		
		
		

	}
	
	
	private static void imprimir(File fichero) {
		
		if(fichero.isDirectory()) {
			for (File f : fichero.listFiles()) {
				
				imprimir(f);
				
			}
			
		}else {
			
			System.out.println(fichero.getName());
			
		}

		
	}

}
