package com.icaballero.strategy;

public class LowerStrategyText implements StrategyTextFormatter{

	@Override
	public void format(String text) {
		System.out.println("Text en Minusculas :"+ text.toLowerCase());
		
	}

}
