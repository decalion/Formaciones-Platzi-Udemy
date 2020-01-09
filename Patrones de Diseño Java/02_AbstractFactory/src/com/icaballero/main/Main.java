package com.icaballero.main;

import com.icaballero.abstractfactory.AbstractFactory;
import com.icaballero.abstractfactory.Card;
import com.icaballero.abstractfactory.FactoryProvider;
import com.icaballero.abstractfactory.PaymentMethod;

public class Main {

	public static void main(String[] args) {
		
		probarAbstractFactory();
		
	}
	
	
	
	private static void probarAbstractFactory() {
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjetaVisa = (Card) abstractFactory.create("VISA");
		
		
		AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");
		
		
		System.out.println(tarjetaVisa.getCardType());
		System.out.println(paymentMethod.doPayment());
	}
}
