package com.icaballero.clasesabstrtactas02;

public abstract class Vehiculo {
	
	
	private String marca;
	
	//Todas las clases hijas deben implementar este metodo siempre que no sean abstractas
	public abstract void acelerar();
	
	public Vehiculo(String marca) {
		super();
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void pagarImpuesto() {
		System.out.println("Impuesto pagado");
	}
	
	
	

}
