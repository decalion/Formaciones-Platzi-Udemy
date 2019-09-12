package com.icaballero.referencias06;

public class FiltroLibros {
	
	public static boolean cienciaFiccion(Libro l) {
		
		return l.getCategoria().contains("ciencia ficcion");
	}
	
	public static boolean libroCaro(Libro l) {
		
		return l.getPrecio()>15 ? true : false;
	}

}
