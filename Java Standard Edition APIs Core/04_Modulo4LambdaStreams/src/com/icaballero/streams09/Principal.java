package com.icaballero.streams09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {

		Ordenador o1= new Ordenador("Lenovo", 700, 256, 8);
		Ordenador o2= new Ordenador("Apple", 1300, 256, 8);
		Ordenador o3= new Ordenador("Dell", 1000, 512, 16);
		Ordenador o4= new Ordenador("Lenovo", 800, 512, 8);
		
		List<Ordenador> listaOrdenador = new ArrayList<Ordenador>();
		
		listaOrdenador.add(o1);
		listaOrdenador.add(o2);
		listaOrdenador.add(o3);
		listaOrdenador.add(o4);
		
		
		//Ejemplo de filtros con streams
		//Esto genera una nueva lista
		List<Ordenador> nuevaLista = listaOrdenador.stream()
		.filter((o) ->o.getPrecio()>=1000)
		.collect(Collectors.toList());
		
		
		//Ejemplo de mapeo
		//Transformamos el precio en double *1.21
		List<Double> mapeoLista = listaOrdenador.stream()
				.filter((o) ->o.getPrecio()>=1000)
				.map( (o)->o.getPrecio()*1.21)
				.collect(Collectors.toList());
		
		
		//Ejemplo de foreach para mostrar datos
		listaOrdenador.stream()
		.filter((o) ->o.getPrecio()>=1000)
		.map( (o)->o.getPrecio()*1.21)
		.forEach((numero)-> System.out.println(numero));
		
		
		System.out.println();
		
		//Ejemplo de foreach con metodo statico
		listaOrdenador.stream()
		.filter((o) ->o.getPrecio()>=1000)
		.map( (o)->o.getPrecio()*1.21)
		.forEach(System.out::println);
		
		System.out.println();
		
		
		
		
		
		for (Ordenador o : nuevaLista) {
			
			System.out.println(o.getMarca());
			
		}
		
		System.out.println();
		for (Double d : mapeoLista) {
			
			System.out.println(d);
			
		}
		
		
		
	}
	
}


