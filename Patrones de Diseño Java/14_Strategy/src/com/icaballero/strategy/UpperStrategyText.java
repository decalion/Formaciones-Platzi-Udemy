package com.icaballero.strategy;

public class UpperStrategyText implements StrategyTextFormatter{

	@Override
	public void format(String text) {
		System.out.println("Texto en Mayusculas : " + text.toUpperCase());
		
	}

}
