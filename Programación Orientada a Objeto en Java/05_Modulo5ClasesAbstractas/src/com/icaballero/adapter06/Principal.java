package com.icaballero.adapter06;

public class Principal {

	public static void main(String[] args) {
		
		Girable b = new BrazoNormal();

		Girable b1 = new BrazoRapido();
		
		Girable c = new Coctelera();
		
		
		Robot r = new Robot();
		
		r.setBrazo(b);
		r.girarBrazo();
		
		r.setBrazo(b1);
		r.girarBrazo();
		
		r.setBrazo(c);
		r.girarBrazo();

		/**
		 * El patron adapter se encarga de cambiar una interfaz por otra
		 * En este caso el Brazo de Acero no gira si no rota
		 */
		Rotable ba = new BrazoAcero();
		r.setBrazo(new AdaptadorBrazoAcero(ba));
		r.girarBrazo();
	}

}
