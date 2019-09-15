package com.icaballero.encapsulacion02;

public class Persona {

	private String nombre;
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		// validamos los valores que se guardan en edad
		if (edad > 120) {
			this.edad = 120;
		} else {
			this.edad = edad;
		}
	}

}
