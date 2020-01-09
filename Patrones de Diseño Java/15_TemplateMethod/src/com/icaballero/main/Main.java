package com.icaballero.main;

import com.icaballero.templatemethod.Payment;
import com.icaballero.templatemethod.Paypal;
import com.icaballero.templatemethod.Visa;

public class Main {
	
	public static void main(String[] args) {
		probarTemplateMethod();
	}
	
	private static void probarTemplateMethod() {
		
		Payment visa = new Visa();
		visa.makePayment();
		
		Payment paypal = new Paypal();
		paypal.makePayment();
	}

}
