package com.icaballero.relaciones1aN_05;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de relacion 1 a N
		 * 
		 * Una Caja de Galletas puede tener muchas galletas
		 * 
		 */

		CajaGalletas miCaja = new CajaGalletas();
		miCaja.addGalleta(new Galleta("Chocolate",1));
		miCaja.addGalleta(new Galleta("Chocolate",1));
		miCaja.addGalleta(new Galleta("Chocolate",1));
		miCaja.addGalleta(new Galleta("Chocolate",1));
		miCaja.addGalleta("Vainilla",3);
		
		System.out.println(miCaja.totalGalletas());
		System.out.println(miCaja.precioTotal());

	}

}
