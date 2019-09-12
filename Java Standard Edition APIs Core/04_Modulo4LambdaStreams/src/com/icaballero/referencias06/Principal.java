package com.icaballero.referencias06;

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
		 *Ejemplo Referencias de Lambda para llamar a los metodos estaticos de la clase FiltroLibros
		 */

		filtro(lista, listaFiltro, FiltroLibros::cienciaFiccion);

		mostrarLibros(listaFiltro);

		System.out.println("**************************");

		listaFiltro.clear();

		filtro(lista, listaFiltro, FiltroLibros::libroCaro);

		mostrarLibros(listaFiltro);

		System.out.println("***************************");

		listaFiltro.clear();
		filtro(lista, listaFiltro, FiltroLibros::cienciaFiccion);

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
