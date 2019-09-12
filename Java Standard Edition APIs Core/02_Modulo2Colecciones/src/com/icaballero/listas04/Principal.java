package com.icaballero.listas04;

public class Principal {

	public static void main(String[] args) {

		Libro libro1 = new Libro("Java", "Ismael Caballero");
		libro1.addCapitulo(new Capitulo("Introduccion", 25));
		libro1.addCapitulo(new Capitulo("Tipos Basicos", 20));

		System.out.println(libro1.totalCapitulos());

		System.out.println(libro1.totalPaginas());

		System.out.println(libro1.contieneCapitulo(new Capitulo("Introduccion", 25)));

		for (Capitulo c : libro1.getListaCapitulos()) {

			System.out.println(c.getTitulo());
		}

		libro1.cambiarCapitulo(new Capitulo("Introduccion", 25), new Capitulo("Introduccion2", 15));

		for (Capitulo c : libro1.getListaCapitulos()) {

			System.out.println(c.getTitulo());
		}

	}

}
