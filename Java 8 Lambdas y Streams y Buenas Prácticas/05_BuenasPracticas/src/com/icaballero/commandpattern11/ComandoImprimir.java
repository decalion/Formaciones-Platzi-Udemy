package com.icaballero.commandpattern11;

import com.icaballero.sorting01.Factura;

public class ComandoImprimir implements ComandoFactura {

	@Override
	public Factura execute(Factura factura) {
		
		System.out.println(factura.getNumero());
		System.out.println(factura.getConcepto());
		System.out.println(factura.getImporte());
		
		return factura;
		
	}

}
