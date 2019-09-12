package com.icaballero.streams11;

public class Ordenador {
	
	private String marca;
	private int precio;
	private int capacidad;
	private int memoria;

	public Ordenador(String marca, int precio, int capacidad, int memoria) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.capacidad = capacidad;
		this.memoria = memoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	
	
	
	
	

}
