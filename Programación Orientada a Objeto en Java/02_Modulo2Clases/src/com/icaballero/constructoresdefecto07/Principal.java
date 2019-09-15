package com.icaballero.constructoresdefecto07;

public class Principal {

	public static void main(String[] args) {
		
		Coche c = new Coche("Toyota","Yaris");
	
		
		System.out.println(c.getMarca());
		System.out.println(c.getModelo());
		
		
		System.out.println();
		Coche c1 = new Coche("Yaris");
	
		
		System.out.println(c1.getMarca());
		System.out.println(c1.getModelo());
		

	}

}
