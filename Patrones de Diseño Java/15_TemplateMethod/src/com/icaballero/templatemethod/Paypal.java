package com.icaballero.templatemethod;

public class Paypal extends Payment {

	@Override
	void initialize() {
		System.out.println("Inicializando el Pago con Paypal");
		
	}

	@Override
	void startPayment() {
		System.out.println("Realizando el Pago con Paypal");
		
	}

	@Override
	void endPayment() {
		System.out.println("Finalizado el Pago con Paypal");
		
	}

}
