package com.icaballero.lambda03;

public class FiltroPrecio implements FiltroLibros {

	@Override
	public boolean test(Libro l) {
		
		return l.getPrecio()> 15;
	}

}
