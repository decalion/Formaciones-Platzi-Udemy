package com.icaballero.app.beans;

public class Saludator {
	
	private String mensaje;
	
	
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public String getMensaje() {
		return mensaje;
	}



	public String saludo() {
		return "Hola Mundo";
	}

}
