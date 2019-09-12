package com.icaballero.streams11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {

		Ordenador o1= new Ordenador("Lenovo", 700, 256, 8);
		Ordenador o2= new Ordenador("Apple", 1300, 256, 8);
		Ordenador o3= new Ordenador("Dell", 1000, 512, 16);
		Ordenador o4= new Ordenador("Hp", 800, 512, 8);
		
		List<Ordenador> listaOrdenador = new ArrayList<Ordenador>();
		
		listaOrdenador.add(o1);
		listaOrdenador.add(o2);
		listaOrdenador.add(o3);
		listaOrdenador.add(o4);
		
	
		//con el metodo peek podemos hacer un seguimiento como si fuera un log
		  listaOrdenador.stream()
		  		.peek((o)->System.out.println(o.getMarca()))
				.filter((o) ->o.getPrecio()>=1000)
				.peek((o)->System.out.println(o.getMarca()))
				.map( (o)->o.getPrecio()*1.21)
				.reduce(Double::sum)
				.ifPresent(System.out::println);
		
		
		
		
		
		
	
	}
	
}


