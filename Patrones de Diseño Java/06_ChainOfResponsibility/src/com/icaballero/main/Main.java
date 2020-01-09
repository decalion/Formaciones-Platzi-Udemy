package com.icaballero.main;

import com.icaballero.chainofresponsibility.Tarjeta;

public class Main {
	
	
	public static void main(String[] args) {
		probarChainOfResponsability();
	}

	
	
	private static void probarChainOfResponsability() {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.creditCardRequest(1000000);
	}
}
