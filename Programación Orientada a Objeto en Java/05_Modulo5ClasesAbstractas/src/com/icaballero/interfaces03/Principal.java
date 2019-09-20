package com.icaballero.interfaces03;

public class Principal {

	public static void main(String[] args) {
		
		Brazo b = new BrazoNormal();

		Brazo b1 = new BrazoRapido();
		
		Brazo c = new Coctelera();
		
		
		Robot r = new Robot();
		
		r.setBrazo(b);
		r.girarBrazo();
		
		r.setBrazo(b1);
		r.girarBrazo();
		
		
		
		
	}

}
