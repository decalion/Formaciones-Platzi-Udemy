package com.icaballero.commandpattern11;

import com.icaballero.sorting01.Factura;

public class ComandoGuardar implements ComandoFactura {

	@Override
	public Factura execute(Factura factura) {
		
		System.out.println("guardando la factura " + factura.getNumero());
		
		return factura;
		
	}

}
