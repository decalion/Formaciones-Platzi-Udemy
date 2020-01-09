package com.icaballero.main;

import com.icaballero.factorymethod.Payment;
import com.icaballero.factorymethod.PaymentFactory;
import com.icaballero.factorymethod.TypePayment;

public class Main {

	
	public static void main(String[] args) {
		
		probarFactoryMethod();
		
		
	}
	
	
	
	private static void probarFactoryMethod() {
		Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
		payment.doPayment();
	}
}
