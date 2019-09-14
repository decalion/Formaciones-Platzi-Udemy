package com.icaballero.exceptions;
/**
 * Clase que representan las excepciones que serán lanzadas en la capa de Servicios
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	
	/**
	 * Constructor
	 * @param message
	 */
	public ServiceException(String message){
		super(message);
	}
}
