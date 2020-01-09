package com.icaballero.iterator;

public class CardIterator implements Iterator{

	private Card[] cards;
	private int position;
	
	public CardIterator(Card[] cards) {
		this.cards = cards;
		position = 0;
	}
	
	
	
	@Override
	public boolean hasNext() {
		
		return position >= cards.length ? false : true;
	}

	@Override
	public Object next() {
		
		return cards[position++];
	}

	@Override
	public Object currentItem() {
		// TODO Auto-generated method stub
		return cards[position];
	}

}
