package com.icaballero.main;



import com.icaballero.strategy.Context;
import com.icaballero.strategy.LowerStrategyText;
import com.icaballero.strategy.UpperStrategyText;

public class Main {
	
	
	public static void main(String[] args) {
		probarStrategy();
	}

	
	private static void probarStrategy() {
		Context context = new Context(new UpperStrategyText());
		context.publishText("Este texto sera convertido en mayusculas");
		
		context = new Context(new LowerStrategyText());
		context.publishText("Este texto sera CONVERTIDO A MINUSCULAS");
	}
}
