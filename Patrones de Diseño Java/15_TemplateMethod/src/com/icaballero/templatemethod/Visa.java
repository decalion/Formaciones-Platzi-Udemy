package com.icaballero.templatemethod;

public class Visa extends Payment{
	
	
	@Override
	void initialize() {
		System.out.println("Inicializando el Pago con Visa");
		
	}

	@Override
	void startPayment() {
		System.out.println("Realizando el Pago con VISA");
		
	}

	@Override
	void endPayment() {
		System.out.println("Finalizado el Pago con VISA");
		
	}

}
