package com.icaballero.lambda03;

public class FiltroTextoJuego implements FiltroLibros {

	@Override
	public boolean test(Libro l) {
		// TODO Auto-generated method stub
		return l.getTitulo().contains("juego");
	}

}
