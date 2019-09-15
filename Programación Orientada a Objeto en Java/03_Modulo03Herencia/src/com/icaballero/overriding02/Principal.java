package com.icaballero.overriding02;

public class Principal {
	
	public static void main(String[] args) {
		

		Persona p1= new Persona();
		p1.setNombre("pedro");
		
		p1.andar();
		
		Deportista d1 = new Deportista();
		d1.setNombre("Gema");
		d1.andar();
	
		
	}

}
