package com.icaballero.app.beans;

public class Saludator {
	
	private String mensaje;
	
	
	
	
	
	public Saludator() {
		super();
	}



	public Saludator(String str) {
		super();
		this.mensaje = str;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public String getMensaje() {
		return mensaje;
	}



	public String saludo() {
		return (mensaje == null) ? "Hola Mundo!!!" : mensaje;
	}

}
