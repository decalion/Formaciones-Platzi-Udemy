package com.icaballero.optional10;

import java.util.Optional;


import com.icaballero.stream01.Persona;

public class Principal2 {

	public static void main(String[] args) {
	
		ServicioPersona servicio = new ServicioPersona();
		Optional<Persona> p = servicio.buscaPorNombre("pedro");
		
		if(p.isPresent()) {
			System.out.println(p.get().getApellido());
		}
		
		
		
	
	}
	

	
	
}
