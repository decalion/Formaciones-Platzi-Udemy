package com.icaballero.serviciosrest;

public class PersonaPartialDTO {
	
	private String apellidos;
	private int edad;
	
	
	public PersonaPartialDTO(String apellidos, int edad) {
		super();
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	
	
	
	public PersonaPartialDTO() {
		super();
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
