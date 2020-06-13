package com.icaballero.sorting01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;





public class Principal {

	
	public static void main(String[] args) {
		
	List<Factura> lista = new ArrayList<Factura>();
	
	Factura f;
	
	for (int i = 0; i < 1_000_000; i++) {
		f= new Factura(i,"concepto"+i,Math.round(Math.random())*10000);
		
		lista.add(f);
		
	}
	
	lista.stream().limit(10).
	//Con sorted lo ordenamos por el metodo de la interfaz comparable
	sorted().
	forEach(System.out::println);
	
	
	
	}
	
	

	

}
