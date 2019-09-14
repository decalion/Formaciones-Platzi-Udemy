package com.icaballero.exceptions;

/**
 * Clase que representan las excepciones que serán lanzadas en la capa de DAOs
 *
 */
@SuppressWarnings("serial")
public class DAOException extends RuntimeException {

	/**
	 * Constructor
	 * @param mensaje
	 */
	public DAOException(String mensaje) {
		super(mensaje);
	}


}
