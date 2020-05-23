package com.icaballero.defaultmethods06;

import com.icaballero.ejemplo01.Persona;

public class FiltroPersonaApellido implements FiltroPersona {
	
	private String apellido;
	

	public FiltroPersonaApellido(String apellido) {
		super();
		this.apellido = apellido;
	}


	@Override
	public boolean test(Persona p) {
		if(p.getApellido().contentEquals(apellido)) {
			return true;
		}else {
			return false;
		}
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

}
