package com.icaballero.main;

import com.icaballero.bridge.ClassicCreditCard;
import com.icaballero.bridge.CreditCard;
import com.icaballero.bridge.SecuredCreditCard;
import com.icaballero.bridge.UnSecureCreditCard;

public class Main {
	
	
	public static void main(String[] args) {
		probarBridge();
	}

	
	private static void probarBridge() {
		CreditCard card = new ClassicCreditCard(new UnSecureCreditCard());
		
		card.realizarPago();
		
		card = new ClassicCreditCard(new SecuredCreditCard());
		card.realizarPago();
		
		
	}
	
}
