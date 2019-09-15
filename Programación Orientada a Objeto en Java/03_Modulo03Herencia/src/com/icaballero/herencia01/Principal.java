package com.icaballero.herencia01;

public class Principal {
	
	public static void main(String[] args) {
		
		Deportista d = new Deportista();
		d.setNombre("Pedro");
		d.setDeporte("Tenis");
		
		System.out.println(d.getNombre());
		System.out.println(d.getDeporte());
		
	}

}
