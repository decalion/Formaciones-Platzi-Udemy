package com.icaballero.prototype;

public class Amex implements PrototypeCard{

	private String name;
	
	@Override
	public void getCard() {
		System.out.println("Esto es una Tarjeta Amex");
		
	}

	@Override
	public PrototypeCard clone() throws CloneNotSupportedException {
		System.out.println("Clonando Tarjeta Amex...");
		return (Amex) super.clone();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
