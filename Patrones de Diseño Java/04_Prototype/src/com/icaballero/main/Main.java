package com.icaballero.main;

import com.icaballero.prototype.PrototypeCard;
import com.icaballero.prototype.PrototypeFactory;
import static com.icaballero.prototype.PrototypeFactory.CardType.*;

public class Main {
	
	public static void main(String[] args) {
		probarPrototype();
	}

	
	private static void probarPrototype() {
		PrototypeFactory.loadCard();
		
		try {
			PrototypeCard visa = PrototypeFactory.getInstance(VISA);
			visa.getCard();
			
			PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
			amex.getCard();
			
			
			
			
		}catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		
	}
}
