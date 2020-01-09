package com.icaballero.abstractfactory;

public class Visa implements Card {

	@Override
	public String getCardType() {
		// TODO Auto-generated method stub
		return "VISA";
	}

	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return "0000-0000-0000-000";
	}

}
