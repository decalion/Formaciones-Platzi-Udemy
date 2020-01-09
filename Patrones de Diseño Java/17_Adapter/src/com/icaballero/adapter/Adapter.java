package com.icaballero.adapter;

public class Adapter implements Payment {

	private Secure securedCreditCard;
	
	public Adapter(String type) {
		if(type.equals("BLACK")) {
			securedCreditCard = new BlackCreditCard();
		}else if(type.equals("GOLD")) {
			securedCreditCard= new GoldCreditCard();
		}
	}
	
	
	@Override
	public void pay(String type) {
		if(type.equals("BLACK")) {
			securedCreditCard.payWithSecureLevelA();
		}else if(type.equals("GOLD")) {
			securedCreditCard.payWithSecureLevelZ();
		}
		
	}

}
