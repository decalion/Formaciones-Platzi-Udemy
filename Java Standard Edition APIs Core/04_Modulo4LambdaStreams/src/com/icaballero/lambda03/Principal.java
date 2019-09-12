package com.icaballero.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		Libro l1 = new Libro("El juego de ender", 20, "ciencia ficcion", 400);
		Libro l2 = new Libro("Harry potter y el caliz de fuego", 25, "fantasia", 600);
		Libro l3 = new Libro("Las hijas del frio", 15, "novela negra", 300);
		Libro l4 = new Libro("Los pilares de la tierra", 30, "historica", 1000);
	

	List<Libro> lista = Arrays.asList(l1,l2,l3,l4);
	
	
	
	List<Libro> listaFiltro = new ArrayList<Libro>();
	
	//Filtros
	/**
	 * Los dos metodos de filtros son iguales
	 * solo cambia la condicion.
	 * Este problema se soluciona con interfaces y expressiones lambda
	 */
	//filtroPaginas(lista, listaFiltro);
	 //filtroPrecio(lista, listaFiltro);
		
	
	/**
	 * Filtros con interfaces
	 */
	//filtro(lista, listaFiltro, new FiltroPrecio());
	//filtro(lista, listaFiltro, new FiltroPaginas());
	//filtro(lista, listaFiltro, new FiltroTextoJuego());
		
		
	/**
	 * Filtros con expresiones Lambda a travez de la interfaz
	 * De esta manera no hace falta implementar ninguna clase
	 */
	//filtro(lista, listaFiltro, (Libro l) -> l.getTitulo().contains("juego"));
	//filtro(lista, listaFiltro, (Libro l) -> l.getPrecio()>15);
	  filtro(lista, listaFiltro, (Libro l) -> l.getPaginas()>400);
	
	 // mostrarLibros(lista);
	mostrarLibros(listaFiltro);
	
	
	
	}

	
	
	//Metodo mas general y mas flexible utilizando una interfaz
	private static void filtro(List<Libro> lista, List<Libro> listaFiltro,FiltroLibros f) {
		
		for (Libro l : lista) {
			
			if(f.test(l)) {
				
				listaFiltro.add(l);
			}
			
		}
	}

	
	
	
	/*
	private static void filtroPrecio(List<Libro> lista, List<Libro> listaFiltro) {
		for (Libro l : lista) {
			
			if(l.getPrecio()> 15) {
				
				listaFiltro.add(l);
			}
			
		}
	}

	private static void filtroPaginas(List<Libro> lista, List<Libro> listaFiltro) {
		for (Libro l : lista) {
			if(l.getPaginas()> 400) {
				listaFiltro.add(l);
			}
			
		}
	}
*/
	private static void mostrarLibros(List<Libro> lista) {
		for (Libro l : lista) {
			
			System.out.println(l.getTitulo());
			
		}
	}
	
	

}
