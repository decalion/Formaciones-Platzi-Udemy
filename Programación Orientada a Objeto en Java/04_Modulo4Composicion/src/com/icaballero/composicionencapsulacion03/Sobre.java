package com.icaballero.composicionencapsulacion03;

public class Sobre {
	
	private String color;
	
	private Galleta galleta;
	

	public Sobre(String color, String sabor, double precio) {
		this.color = color;
		this.galleta = new Galleta(sabor, precio);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	//Metodo delegado
	public String getSabor() {
		return galleta.getSabor();
	}

	//Metodo delegado
	public double getPrecio() {
		return galleta.getPrecio();
	}
	
	
	
	
	

}
