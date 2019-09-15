package com.icaballero.metodosestaticos10;

public class Coche {
	
	private String marca;
	private String modelo;
	
	private static int contador;
	

	public Coche() {
		//Delegacion de constructtores
		this("Toyota","Yaris");
	}


	public Coche(String modelo) {
		
		this("Toyata",modelo);

	}



	public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		
		contador++;
	}
	
	
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	//Metodo de clase
	public static int getContador() {
		return contador;
	}
	


}
