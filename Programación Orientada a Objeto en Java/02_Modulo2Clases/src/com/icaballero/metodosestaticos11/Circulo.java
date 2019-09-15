package com.icaballero.metodosestaticos11;

public class Circulo {
	
	private double radio;
	
	
	
	

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	//Metodo de instancia
	public  double area() {
		//Delegamos en el metodo de clase
		return Circulo.area(this.radio);
	}
	
	//Metodo de clase
	public static  double area(double radio) {
		return 2*Math.PI*radio;
	}
	
	
	

}
