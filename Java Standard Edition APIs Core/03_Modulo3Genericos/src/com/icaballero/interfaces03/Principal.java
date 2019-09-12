package com.icaballero.interfaces03;

public class Principal {

	public static void main(String[] args) {
		
		Galleta g1 = new Galleta("chocolate",0.1);
		Galleta g2 = new Galleta("vainilla",0.1);
		Galleta g3 = new Galleta("fresa",0.2);
		
		
		Caja<Galleta> cajaGalletas = new Caja<Galleta>(2);
		cajaGalletas.add(g1);
		cajaGalletas.add(g2);
		//no se inserta porque no cabe
		cajaGalletas.add(g3);
		
		System.out.println(cajaGalletas.precioTotal());
		
		
	}

}
