package com.icaballero.interfacesfiltros02;

public class FiltroPrecio implements FiltroLibros {

	@Override
	public boolean test(Libro l) {
		
		return l.getPrecio()> 15;
	}

}
