package com.icaballero.clasesabstrtactas02;

public class Principal {
	
	public static void main(String[] args) {
		
		Moto m = new Moto("ducati");
		Coche c = new Coche("Toyota");
		Camion ca= new Camion("Scania");
		
		System.out.println(m.getMarca());
		
		c.pagarImpuesto();
		
		acelerarVehiculo(c);
		acelerarVehiculo(m);
		acelerarVehiculo(ca);
		
		
	}
	
	
	//El programador que desarolla no necesita saber la jerarquia de clases
	public static void acelerarVehiculo(Vehiculo v) {
		v.acelerar();
	}

}
