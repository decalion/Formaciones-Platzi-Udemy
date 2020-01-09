package com.icaballero.visitor;

public interface OfertaElement {
	void accept(CreditCardVisitor visitor);

}
