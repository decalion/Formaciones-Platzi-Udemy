package com.icaballero.casting05;

public class Principal {
	
	public static void main(String[] args) {
		
	Persona p1 = new Deportista("gema", "padel");
	
	System.out.println(p1.getNombre());
	p1.andar();
	Deportista d = (Deportista) p1;
	System.out.println(d.getDeporte());
	
	System.out.println(((Deportista)p1).getDeporte());


	}
	


}
