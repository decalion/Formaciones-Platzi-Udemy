package com.icaballero.main;

import com.icaballero.singleton.Card;

public class Main {
	
	public static void main(String[] args) {
		probarSingleton();
	}

	
	
	private static void probarSingleton() {
		Card card = Card.getInstance();
		card.setCardNumber("0000-0000-000");
	
		System.out.println(card.getCardNumber());
	
		Card card2 = Card.getInstance();
		System.out.println(card2.getCardNumber());
	}
	
}
