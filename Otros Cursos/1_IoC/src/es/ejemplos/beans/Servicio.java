package es.ejemplos.beans;

public class Servicio {
	private Integer num1;
	private Integer num2;
	
	public Servicio(){
		num1 = 5;
		num2 = 4;
	}
	
	public int hacerOperacion(){
		return num1 + num2;
	}

}
