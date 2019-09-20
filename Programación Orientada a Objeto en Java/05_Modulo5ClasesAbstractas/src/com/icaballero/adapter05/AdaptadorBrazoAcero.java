package com.icaballero.adapter05;


/**
 * El patron adapter se encarga de cambiar una interfaz por otra
 * En este caso el Brazo de Acero no gira si no rota
 * @author ismael
 *
 */
public class AdaptadorBrazoAcero implements Girable {
	
	private BrazoAcero brazoAcero;

	public AdaptadorBrazoAcero(BrazoAcero ba) {
		super();
		this.brazoAcero = ba;
	}

	public BrazoAcero getBrazoAcero() {
		return brazoAcero;
	}

	public void setBrazoAcero(BrazoAcero ba) {
		this.brazoAcero = ba;
	}

	@Override
	public void girar() {
		//Metodo que adapta el brazo de acero al robot
		//usando delegacion
		brazoAcero.rotar();
		
	}
	
	

}
