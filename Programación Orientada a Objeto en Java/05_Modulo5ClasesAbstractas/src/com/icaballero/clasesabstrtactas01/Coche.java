package com.icaballero.clasesabstrtactas01;

public class Coche extends Vehiculo {

	public Coche(String marca) {
		super(marca);

	}

	@Override
	public void acelerar() {
		System.out.println("El coche acelera");
		
	}
	

	

}
