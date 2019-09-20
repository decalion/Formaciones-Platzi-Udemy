package com.icaballero.clasesabstrtactas01;

public class Camion extends Vehiculo {

	public Camion(String marca) {
		super(marca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acelerar() {
		System.out.println("El camion acelera");
		
	}

}
