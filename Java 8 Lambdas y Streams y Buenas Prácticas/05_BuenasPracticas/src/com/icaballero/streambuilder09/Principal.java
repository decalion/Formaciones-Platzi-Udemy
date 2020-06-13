package com.icaballero.streambuilder09;

import java.util.stream.Stream;

public class Principal {

	
	public static void main(String[] args) {

	
		Stream<Integer> mistream = streamNumeros(100);
		
		mistream.forEach(System.out::println);
		
		

	}
	
	//100 primeros numeros pares
	private static Stream<Integer> streamNumeros(int tope){
		
		Stream.Builder<Integer> builder = Stream.builder();
		
		for (int i = 0; i < tope; i++) {
			
			if(i%2==0) {
				builder.add(i);
			}
			
			
		}
		//Construya el stream que necesitamos
		return builder.build();
		
	}
		
	

}
