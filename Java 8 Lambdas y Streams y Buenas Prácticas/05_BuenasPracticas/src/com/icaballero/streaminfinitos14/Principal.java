package com.icaballero.streaminfinitos14;



import java.util.Optional;
import java.util.stream.Stream;

import com.icaballero.sorting01.Factura;

public class Principal {

	
	public static void main(String[] args) {

		Stream<Integer> miStream = Stream.iterate(0, i->i+1);
		
		Optional<Integer> op = miStream.limit(1000).reduce(Integer::sum);
		
		if(op.isPresent()) {
			System.out.println(op.get());
		}
	

	}
	

		
	

}
