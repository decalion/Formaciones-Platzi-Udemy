package com.icaballero.bifunction08;

public class Documento {
	
	private String titulo;
	private int version;
	

	public Documento(String titulo, int version) {
		super();
		this.titulo = titulo;
		this.version = version;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	//BiOperator ya que recibe 2 parametros del mismo tipo
	//Devuelve un parametro de ese tipo
	public static Documento esMayor(Documento actual, Documento siguiente) {
		
		if(actual.getVersion() > siguiente.getVersion()) {
			
			return actual;
		}else {
			return siguiente;
		}
		
	}
	
	
	

}
