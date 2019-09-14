package com.icaballero.domain;

/**
 * POJO class for EventSignUp
 * 
 * @author Ismael Caballero
 */

public class EventSignUp {

	private int id; // identificador unico
	private int idVisitor; // id del visitante
	private int idEvent; // id del evento

	// Constructor vacio
	public EventSignUp() {
	}

	/**
	 * Metodo que devuelve el ID
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo para guardar el id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que devuelve el IdVisitor
	 * 
	 * @return
	 */
	public int getIdVisitor() {
		return idVisitor;
	}

	/**
	 * Metodo para guardar el IdVisitor
	 * 
	 * @param idVisitor
	 */
	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	/**
	 * Metodo que devuelve el IdEvent
	 * 
	 * @return
	 */
	public int getIdEvent() {
		return idEvent;
	}

	/**
	 * Metodo para guardar el Id Event
	 * 
	 * @param idEvent
	 */
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

}
