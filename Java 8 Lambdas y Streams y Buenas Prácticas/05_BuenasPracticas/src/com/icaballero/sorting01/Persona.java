package com.icaballero.sorting01;

import java.util.ArrayList;
import java.util.List;

public class Persona implements Comparable<Persona> {
	
	
	private String nombre;
	private String apellido;
	private int edad;
	
	List<Deporte> deportes = new ArrayList<Deporte>();
	

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

	
	
	
	public List<Deporte> getDeportes() {
		return deportes;
	}
	public void setDeportes(List<Deporte> deportes) {
		this.deportes = deportes;
	}
	public  boolean estaJubilado() {
		
		
		return this.getEdad() > 65;
	}
	@Override
	public String toString() {
		
		return this.getNombre() +" " + this.getApellido();
	}
	
	
	public void addDeporte(Deporte deporte) {
		this.deportes.add(deporte);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((deportes == null) ? 0 : deportes.hashCode());
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (deportes == null) {
			if (other.deportes != null)
				return false;
		} else if (!deportes.equals(other.deportes))
			return false;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
