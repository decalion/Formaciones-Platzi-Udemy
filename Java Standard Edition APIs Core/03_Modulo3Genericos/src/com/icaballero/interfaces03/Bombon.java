package com.icaballero.interfaces03;

public class Bombon implements Producto {
	
	private String tipo;
	private double precio;

	public Bombon(String tipo,double precio) {
		super();
		this.tipo = tipo;
		this.precio=precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
