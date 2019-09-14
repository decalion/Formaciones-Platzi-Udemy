package com.icaballero.domain;

public class Coche {

	private String modelo;
	private String marca;
	private int km;
	
	public Coche() {
		super();
	}

	public Coche(String modelo, String marca, int km) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.km = km;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", marca=" + marca + ", km=" + km
				+ "]";
	}
	
	
}
