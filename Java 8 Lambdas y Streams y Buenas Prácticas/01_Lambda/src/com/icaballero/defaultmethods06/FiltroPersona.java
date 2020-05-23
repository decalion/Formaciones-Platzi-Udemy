package com.icaballero.defaultmethods06;

import com.icaballero.ejemplo01.Persona;

public interface FiltroPersona {
	
	
	public boolean test(Persona p);
	
	
	//Añade una clausula or sobre el filtro activo
	default public FiltroPersona or(FiltroPersona filtro) {
		
		return (Persona p) -> { return test(p) || filtro.test(p);};
	}

}
