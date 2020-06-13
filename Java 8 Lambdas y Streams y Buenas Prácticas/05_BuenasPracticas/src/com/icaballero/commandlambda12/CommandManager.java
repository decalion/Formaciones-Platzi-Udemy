package com.icaballero.commandlambda12;

import com.icaballero.sorting01.Factura;

public class CommandManager {

	public static Factura guardar(Factura factura) {

		System.out.println("guardando la factura " + factura.getNumero());

		return factura;

	}

	public static Factura imprimir(Factura factura) {

		System.out.println(factura.getNumero());
		System.out.println(factura.getConcepto());
		System.out.println(factura.getImporte());

		return factura;

	}

	public static Factura email(Factura factura) {

		System.out.println("enviando por email la factura " + factura.getNumero());

		return factura;

	}

}
