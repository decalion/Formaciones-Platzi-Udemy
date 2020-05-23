package com.icaballero.comparadores02;

import java.util.Comparator;

import com.icaballero.ejemplo01.Persona;

public class ComparadorApellidos implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {
		
		return persona1.getApellido().compareTo(persona2.getApellido());
	}

}
