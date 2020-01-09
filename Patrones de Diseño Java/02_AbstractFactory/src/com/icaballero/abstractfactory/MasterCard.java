package com.icaballero.abstractfactory;

public class MasterCard implements Card{

	@Override
	public String getCardType() {
		// TODO Auto-generated method stub
		return "MASTERCARD";
	}

	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return "1111-1111-1111-1111";
	}

}
