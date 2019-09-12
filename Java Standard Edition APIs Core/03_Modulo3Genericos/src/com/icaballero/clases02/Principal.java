package com.icaballero.clases02;

public class Principal {

	public static void main(String[] args) {
		
		Galleta g1 = new Galleta("chocolate");
		Galleta g2 = new Galleta("vainilla");
		Galleta g3 = new Galleta("fresa");
		Galleta g4 = new Galleta("chocolate");
		
		
		PackDoble<Galleta> miPack = new PackDoble<Galleta>(g1,g2);
	
		System.out.println(miPack.getItem1().getSabor());
		
		System.out.println(g1.equals(g4));
		
		System.out.println(miPack.iguals());
		
	
	}

}
