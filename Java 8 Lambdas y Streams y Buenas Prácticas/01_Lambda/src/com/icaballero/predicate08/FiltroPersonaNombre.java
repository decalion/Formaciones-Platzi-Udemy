package com.icaballero.predicate08;

import java.util.function.Predicate;

import com.icaballero.ejemplo01.Persona;

public class FiltroPersonaNombre implements Predicate<Persona> {

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
