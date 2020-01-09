package com.icaballero.prototype;

public class Visa implements PrototypeCard {

	private String name;
	
	@Override
	public void getCard() {
		System.out.println("Esto es una Tarjeta Visa");
		
	}

	@Override
	public PrototypeCard clone() throws CloneNotSupportedException {
		System.out.println("Clonando tarjeta visa ....");
		return (Visa) super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
