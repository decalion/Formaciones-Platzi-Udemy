package com.icaballero.adapter;

public class CreditCard implements Payment {

	private Adapter adapter;
	
	
	@Override
	public void pay(String type) {
		if(type.equals("CLASSIC")) {
			System.out.println("Pagando sin ningun tipo de seguridad");
		}
		else if(type.equals("BLACK")) {
			adapter = new Adapter(type);
			adapter.pay(type);
		}else if(type.equals("GOLD")) {
			 adapter = new Adapter(type);
		}	 adapter.pay(type);
		
	}

}
