package com.icaballero.main;

import com.icaballero.adapter.CreditCard;

public class Main {

	public static void main(String[] args) {
		probarAdapter();
	}
	
	
	
	private static void probarAdapter() {
		CreditCard creditCard = new CreditCard();
		creditCard.pay("GOLD");
		creditCard.pay("BLACK");
		creditCard.pay("CLASSIC");
	}
}
