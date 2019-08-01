package com.icaballero.amazonviewer.domain;

import java.util.Date;

/**
 * 
 * 
 * @author Ismael Caballero
 * @version 1.0
 * @since 2019
 *
 */
public interface IVisualizable {
	
	/**
	 * Este metodo captura el tiempo exacto de inicio de visualizacion
	 * @param dateI Es un objeto {@code Date} con el tiempo exacto de inicio
	 * @return Devuelve la fecha y hora capturada
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Este metodo captura el tiempo exacto de inicio  y finalde visualizacion
	 * @param dateI   Es un objeto {@code Date} con el tiempo exacto de inicio
	 * @param dateF   Es un objeto {@code Date} con el tiempo exacto de final exacto
	 */
	void stopToSee(Date dateI , Date dateF);

}
