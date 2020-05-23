package com.icaballero.staticmethods09;

import java.util.function.Predicate;

import com.icaballero.ejemplo01.Persona;

public interface FiltroPersona extends Predicate<Persona> {
	
	
	//Pasar multiples parametros del ismo tipo
	public static Predicate<Persona> orMultiple(Predicate<Persona> ...predicados) {
		
		Predicate<Persona> combinarPredicados = predicados[0];
		
		for (Predicate<Persona> predicado : predicados) {
			
			combinarPredicados = combinarPredicados.or(predicado);
		}
		
		return combinarPredicados;
		
	}

}
