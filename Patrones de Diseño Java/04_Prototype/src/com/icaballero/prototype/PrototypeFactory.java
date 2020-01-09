package com.icaballero.prototype;

import java.util.HashMap;
import java.util.Map;
import static com.icaballero.prototype.PrototypeFactory.CardType.*;

public class PrototypeFactory {
	
	
	public static class CardType{
		public static final String VISA = "visa";
		public static final String AMEX = "amex";
	}

	
	public static Map<String,PrototypeCard> prototypes = new HashMap<>();
	
	
	public static PrototypeCard getInstance(final String tipo) throws CloneNotSupportedException{
		return prototypes.get(tipo).clone();
	}
	
	
	public static void loadCard() {
		Visa visa = new Visa();
		visa.setName("Esta arjeta es visa con numero 0000");
		prototypes.put(VISA, visa);
		
		Amex amex = new Amex();
		visa.setName("Esta arjeta es Amex con numero 0000");
		prototypes.put(AMEX, amex);
	}
}
