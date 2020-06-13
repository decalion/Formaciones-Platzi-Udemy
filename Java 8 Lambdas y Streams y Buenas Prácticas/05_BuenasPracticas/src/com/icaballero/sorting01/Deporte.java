package com.icaballero.sorting01;

public class Deporte {
	
	@Override
	public String toString() {
		return "Deporte [nombre=" + nombre + ", horas=" + horas + "]";
	}
	private String nombre;
	private int horas;
	

	public Deporte(String nombre, int horas) {
		super();
		this.nombre = nombre;
		this.horas = horas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	
	

}
