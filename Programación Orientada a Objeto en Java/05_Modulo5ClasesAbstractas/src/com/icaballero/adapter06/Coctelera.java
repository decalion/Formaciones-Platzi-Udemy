package com.icaballero.adapter06;

public class Coctelera implements Girable {

	private String tipoAspa;

	public String getTipoAspa() {
		return tipoAspa;
	}

	public void setTipoAspa(String tipoAspa) {
		this.tipoAspa = tipoAspa;
	}

	public void girar() {
		System.out.println("La coctelera gira a 50 vueltas minuto");

	}

}
