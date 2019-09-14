package com.icaballero.util;

import java.util.Comparator;

import es.coritel.codington.festival.domain.Event;

public class CompatorEventNameDesc implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
