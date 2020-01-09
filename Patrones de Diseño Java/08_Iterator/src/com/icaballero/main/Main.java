package com.icaballero.main;

import com.icaballero.iterator.Card;
import com.icaballero.iterator.CardList;
import com.icaballero.iterator.Iterator;
import com.icaballero.iterator.List;

public class Main {

	public static void main(String[] args) {
		probarIterator();
	}
	
	
	private static void probarIterator() {
		Card[] cards = new Card[5];
		cards[0] = new Card("VISA");
		cards[1] = new Card("AMEX");
		cards[2] = new Card("MASTERCARD");
		cards[3] = new Card("GOOGLECARD");
		cards[4] = new Card("APPLECARD");
		
		List lista = new CardList(cards);
		Iterator iterator = lista.iterator();
		
		while (iterator.hasNext()) {
			Card card = (Card) iterator.next();
			System.out.println(card.getType());
		}
		
	}
}
