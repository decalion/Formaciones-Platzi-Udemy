package com.icaballero.commandpattern11;

import com.icaballero.sorting01.Factura;

public class ComandoEmail implements ComandoFactura {

	@Override
	public Factura execute(Factura factura) {
		
		System.out.println("enviando por email la factura " + factura.getNumero());
		
		return factura;
		
	}

}
