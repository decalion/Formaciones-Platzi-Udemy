package com.icaballero.main;

import com.icaballero.builder.Card;
import com.icaballero.builder.Card.CardBuilder;

public class Main {
	
	public static void main(String[] args) {
		probarBuilder();
		
	}

	
	
	private static void probarBuilder() {
		Card card = new CardBuilder("VISA", "0000-0000-0000")
				.name("Ismael Caballero")
				.expires(2030)
				.credit(false)
				.build();
		
		
		Card card2 = new CardBuilder("MASTERCARD", "9999-9999-9999")
				.build();
		
		
		System.out.println(card);
		System.out.println(card2);
	}
}
