package com.icaballero.serviciosrest;

public class PersonaDTO {
	
	private String nombre;
	private String apellidos;
	private int edad;
	

	public PersonaDTO() {
		super();
	}
	
	public PersonaDTO(Persona persona) {
		this.setNombre(persona.getNombre());
		this.setApellidos(persona.getApellidos());
		this.setEdad(persona.getEdad());
	}
	
	
	public PersonaDTO(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	

}
