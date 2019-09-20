package com.icaballero.interfaces03;

public class Robot {
	
	//compposicion
	private Brazo brazo;

	public Brazo getBrazo() {
		return brazo;
	}

	public void setBrazo(Brazo brazo) {
		this.brazo = brazo;
	}
	
	public void girarBrazo() {
		brazo.girar();
	}
	

}
