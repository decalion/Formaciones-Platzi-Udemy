package com.icaballero.interfazfsupplier05;

import com.icaballero.consumer01.Persona;

public class ServicioFirma {
	
	private Persona persona;
	
	public ServicioFirma(Persona persona) {
		
		this.persona = persona;
		
	}
	
	public String obtenerFirma() {
		
		return "Firma de la persona: " + persona.getNombre();
		
	}
	
	

}
