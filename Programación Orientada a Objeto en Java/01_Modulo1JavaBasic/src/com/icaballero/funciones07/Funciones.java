package com.icaballero.funciones07;

public class Funciones {

	public static void main(String[] args) {

		holas();

		adios();

		holas();

	}

	private static void adios() {
		mensaje("Adios", 4);
	}

	private static void holas() {
		mensaje("Hola", 4);
	}

	private static void mensaje(String mensaje, int repeticiones) {

		for (int i = 0; i < repeticiones; i++) {

			System.out.println(mensaje);

		}

	}

}
