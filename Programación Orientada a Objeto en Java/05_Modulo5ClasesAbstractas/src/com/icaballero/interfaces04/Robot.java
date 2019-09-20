package com.icaballero.interfaces04;

public class Robot {
	
	//compposicion
	private Girable brazo;

	public Girable getBrazo() {
		return brazo;
	}

	public void setBrazo(Girable brazo) {
		this.brazo = brazo;
	}
	
	public void girarBrazo() {
		brazo.girar();
	}
	

}
