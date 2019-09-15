package com.icaballero.super03;

public class Persona {
	
	private String nombre;
	

	public Persona() {
	

	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void imprimeTextoAndar() {
		System.out.print(getNombre() +" camina a ");
	}
	
	
	public void andar() {
		imprimeTextoAndar();
		System.out.println(" 5km/h");
	}
	

}
