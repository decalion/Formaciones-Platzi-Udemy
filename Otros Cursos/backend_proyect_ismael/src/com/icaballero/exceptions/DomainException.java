package com.icaballero.exceptions;

/**
 * Clase que representan las excepciones que ser�n lanzadas en la capa de Dominio
 * 
 */
@SuppressWarnings("serial")
public class DomainException extends RuntimeException {
	
	
	/**
	 * Constructor
	 * @param mensaje
	 */
	public DomainException (String mensaje){
		super(mensaje);
	}

	
}
