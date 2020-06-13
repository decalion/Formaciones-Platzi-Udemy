package com.icaballero.slicing01;

public class Persona implements Comparable<Persona> {
	
	
	private String nombre;
	private String apellido;
	private int edad;
	
	

	public Persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public int compareTo(Persona otro) {
		return this.getNombre().compareTo(otro.getNombre());
	}

	
	
	
	public  boolean estaJubilado() {
		
		
		return this.getEdad() > 65;
	}
	@Override
	public String toString() {
		
		return this.getNombre() +" " + this.getApellido();
	}
	
	
	
	
}
