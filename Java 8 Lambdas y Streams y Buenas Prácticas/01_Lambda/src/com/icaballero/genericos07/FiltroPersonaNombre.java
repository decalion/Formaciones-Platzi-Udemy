package com.icaballero.genericos07;

import com.icaballero.ejemplo01.Persona;

public class FiltroPersonaNombre implements Filtro<Persona> {

	private String nombre;
	

	public FiltroPersonaNombre(String nombre) {
		super();
		this.nombre = nombre;
	}


	@Override
	public boolean test(Persona p) {
		if(p.getNombre().contentEquals(nombre)) {
			return true;
		}else {
			return false;
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}
