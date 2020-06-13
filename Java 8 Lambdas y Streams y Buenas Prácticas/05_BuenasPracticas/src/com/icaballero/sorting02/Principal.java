package com.icaballero.sorting02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.icaballero.sorting01.Factura;





public class Principal {

	
	public static void main(String[] args) {
		
	List<Factura> lista = new ArrayList<Factura>();
	
	Factura f;
	
	for (int i = 0; i < 1_000_000; i++) {
		f= new Factura(i,"concepto"+i,Math.round(Math.random())*10000);
		
		lista.add(f);
		
	}
	
	//Saber cuanto tiempo tarda en hacer esta operacion
	long t1= System.nanoTime();
	List<Double> nueva = lista.stream().map(Factura::getImporte).collect(Collectors.toList());
	long t2= System.nanoTime();
	System.out.println(t2-t1);
	
	
	long t3= System.nanoTime();
	List<Double> nueva2 = lista.stream().sorted().map(Factura::getImporte).collect(Collectors.toList());
	long t4= System.nanoTime();
	System.out.println(t4-t3);
	
	
	}
	
	

	

}
