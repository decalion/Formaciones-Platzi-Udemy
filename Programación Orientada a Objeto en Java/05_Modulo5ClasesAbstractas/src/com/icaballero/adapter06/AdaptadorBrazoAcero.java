package com.icaballero.adapter06;


/**
 * El patron adapter se encarga de cambiar una interfaz por otra
 * En este caso el Brazo de Acero no gira si no rota
 * @author ismael
 *
 */
public class AdaptadorBrazoAcero implements Girable {
	
	private Rotable brazoAcero;

	public AdaptadorBrazoAcero(Rotable ba) {
		super();
		this.brazoAcero = ba;
	}

	public Rotable getBrazoAcero() {
		return brazoAcero;
	}

	public void setBrazoAcero(Rotable ba) {
		this.brazoAcero = ba;
	}

	@Override
	public void girar() {
		//Metodo que adapta el brazo de acero al robot
		//usando delegacion
		brazoAcero.rotar();
		
	}
	
	

}
