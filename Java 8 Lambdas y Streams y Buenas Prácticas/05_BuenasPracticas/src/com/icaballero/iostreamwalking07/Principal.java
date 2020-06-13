package com.icaballero.iostreamwalking07;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.icaballero.sorting01.Factura;





public class Principal {

	
	public static void main(String[] args) {

		Stream<Path> mistream = null;
		try {
			mistream = Files.walk(Paths.get("./src"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mistream.forEach(System.out::println);

	}
	
	
		
	

}
