package com.icaballero.ficherosstream10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Principal {

	
	public static void main(String[] args) {

	 Pattern patron1 = Pattern.compile(",");
	 Pattern patron2 = Pattern.compile("[0-9]+");
		
		try {
			Stream<String> stream  = Files.lines(Paths.get("./texto.txt"));
			stream.
			flatMap(s->patron1.splitAsStream(s)).
			filter(patron2.asPredicate()).
			map(Integer::parseInt).
			reduce(Integer::sum).
			ifPresent(System.out::println);
			//forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	

		
	

}
