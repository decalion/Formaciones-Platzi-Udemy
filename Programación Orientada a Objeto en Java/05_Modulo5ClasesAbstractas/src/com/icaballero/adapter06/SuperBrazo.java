package com.icaballero.adapter06;

//Implementa 2 interfaces
public class SuperBrazo implements Girable,Rotable {

	@Override
	public void rotar() {
		System.out.println("El super Brazo Rota");
		
	}

	@Override
	public void girar() {
		System.out.println("El super Brazo Gira");
		
	}
	
	
	

}
