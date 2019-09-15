package com.icaballero.sobrecargaestatica03;

public class Principal {

	public static void main(String[] args) {
		
		Libro l1 = new Libro();
		l1.setTitulo("El juego de ender");
		l1.setTotalPaginas(200);
		
		System.out.println(l1.getPaginaActual());
		l1.avanzarPagina();
		System.out.println(l1.getPaginaActual());
		l1.avanzarPagina();
		System.out.println(l1.getPaginaActual());
		l1.avanzarPagina(30);
		System.out.println(l1.getPaginaActual());

	}

}
