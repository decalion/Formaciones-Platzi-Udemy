package com.icaballero.strategy;

public class Context {
	
	private StrategyTextFormatter strategyTextFormatter;

	public Context(StrategyTextFormatter strategyTextFormatter) {
		super();
		this.strategyTextFormatter = strategyTextFormatter;
	}
	
	public void publishText(String text) {
		strategyTextFormatter.format(text);
	}

}
