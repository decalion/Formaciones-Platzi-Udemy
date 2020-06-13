package com.icaballero.comparator03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.icaballero.sorting01.Factura;





public class Principal {

	
	public static void main(String[] args) {
		
	List<Factura> lista = new ArrayList<Factura>();
	
	Factura f;
	
	for (int i = 0; i < 1_000_000; i++) {
		f= new Factura(i,"concepto"+i,Math.round(Math.random()*10000));
		
		lista.add(f);
		
	}
	
//	lista.stream().limit(10).
//	//El metodo comparing nos permite comparar por cualquier propiedad
//	sorted(Comparator.comparing(Factura::getConcepto)).
//	forEach(System.out::println);
	
	
	
	
//	lista.stream().limit(1000).
//	//compara por importe y por numero
//	sorted(Comparator.comparing(Factura::getImporte).thenComparing(Factura::getNumero)).
//	forEach(System.out::println);
	
	
	lista.stream().limit(1000).
	sorted(Comparator.comparing(Factura::getImporte).
	thenComparing(Factura::getNumero)
	//Con reverse los ordenamos al reves
	.reversed()).
	forEach(System.out::println);
	
	
	}
	
	

	

}
