package com.icaballero.main;

import com.icaballero.visitor.BlackCreditCardVisitor;
import com.icaballero.visitor.ClassicCreditCardVisitor;
import com.icaballero.visitor.OfertaElement;
import com.icaballero.visitor.OfertaGasolina;
import com.icaballero.visitor.OfertaVuelos;

public class Main {
	
	
	public static void main(String[] args) {
		
		probarVisitor();
	}
	
	private static void probarVisitor() {
		OfertaElement ofertaElement = new OfertaGasolina();
		ofertaElement.accept(new BlackCreditCardVisitor());
		
		ofertaElement = new OfertaVuelos();
		ofertaElement.accept(new ClassicCreditCardVisitor());
	}

}
