package com.icaballero.predicate08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Principal {

	public static void main(String[] args) {

		Libro l1 = new Libro("El juego de ender", 20, "ciencia ficcion", 400);
		Libro l2 = new Libro("Harry potter y el caliz de fuego", 25, "fantasia", 600);
		Libro l3 = new Libro("Las hijas del frio", 15, "novela negra", 300);
		Libro l4 = new Libro("Los pilares de la tierra", 30, "historica", 1000);

		List<Libro> lista = Arrays.asList(l1, l2, l3, l4);

		List<Libro> listaFiltro = new ArrayList<Libro>();

		
		
		/**
		 *Ejemplo de predicate y sus metodos
		 *con el metodo and podemos a�adir mas filtros
		 *Con el metodo and obligamos a que se cumplan los 2 filtros
		 *con el metodo or tiene que ser un filtro o otro
		 */

		//
		Predicate<Libro> miFiltro =(Libro l) -> l.getPaginas()>400;
		
		Predicate<Libro> nuevoFiltro=miFiltro.and((Libro l) -> l.getPaginas()<800).or((Libro l) -> l.getCategoria().equals("historica"));
		
		
		
		
		filtro(lista, listaFiltro, nuevoFiltro);

		mostrarLibros(listaFiltro);

		

	}

	// Metodo mas general y mas flexible utilizando una interfaz
	private static void filtro(List<Libro> lista, List<Libro> listaFiltro, Predicate<Libro> f) {

		for (Libro l : lista) {

			if (f.test(l)) {

				listaFiltro.add(l);
			}

		}
	}

	private static void mostrarLibros(List<Libro> lista) {
		for (Libro l : lista) {

			System.out.println(l.getTitulo());

		}
	}

}
