package com.icaballero.main;

import com.icaballero.command.CreditCard;
import com.icaballero.command.CreditCardActivateCommand;
import com.icaballero.command.CreditCardDesactivateCommand;
import com.icaballero.command.CreditCardInvoke;

public class Main {
	
	public static void main(String[] args) {
		probarCommand();
	}

	
	
	private static void probarCommand() {
		CreditCard card = new CreditCard();
		CreditCardActivateCommand activated = new CreditCardActivateCommand(card);
		CreditCardDesactivateCommand desactivate = new CreditCardDesactivateCommand(card);
		
		CreditCardInvoke invoker = new CreditCardInvoke();
		
		invoker.setCommand(activated);
		invoker.run();
		
		invoker.setCommand(desactivate);
		invoker.run();
		
	}
}
