package com.icaballero.lambda03;

public class FiltroPaginas implements FiltroLibros {

	@Override
	public boolean test(Libro l) {
		
		return l.getPaginas()> 400;
	}

}
