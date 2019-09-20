package com.icaballero.clasesabstrtactas02;

public class Coche extends Vehiculo {

	public Coche(String marca) {
		super(marca);

	}

	@Override
	public void acelerar() {
		System.out.println("El coche acelera");
		
	}
	

	

}
