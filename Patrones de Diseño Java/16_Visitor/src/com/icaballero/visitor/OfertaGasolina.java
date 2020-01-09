package com.icaballero.visitor;

public class OfertaGasolina implements OfertaElement {

	@Override
	public void accept(CreditCardVisitor visitor) {
		visitor.ofertaGasolina(this);
		
	}

}
