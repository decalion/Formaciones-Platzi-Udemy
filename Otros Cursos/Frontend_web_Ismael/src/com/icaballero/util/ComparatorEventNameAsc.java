package com.icaballero.util;

import java.util.Comparator;

import es.coritel.codington.festival.domain.Event;

public class ComparatorEventNameAsc implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
		
		return o2.getName().compareTo(o1.getName());
	}

}
