package com.icaballero.clases01;

public class Principal {

	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo();
		r1.lado1=2;
		r1.lado2=3;
		
		System.out.println(r1.lado1);
		System.out.println(r1.lado2);
		System.out.println(r1.area());
		System.out.println(r1.perimetro());
		
		System.out.println();
		Rectangulo r2 = new Rectangulo();
		r2.lado1=1;
		r2.lado2=1;
		
		System.out.println(r2.lado1);
		System.out.println(r2.lado2);
		System.out.println(r2.area());
		System.out.println(r2.perimetro());
		
	}

}
