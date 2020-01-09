package com.icaballero.visitor;

public class BlackCreditCardVisitor implements CreditCardVisitor {

	@Override
	public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
		System.out.println("Descuento del 10% en Gasolina con tu tarjeta black");
		
	}

	@Override
	public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
		System.out.println("Descuento del 25% en vuelos con tu tarjeta black");
		// TODO Auto-generated method stub
		
	}

}
