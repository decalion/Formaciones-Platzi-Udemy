package com.icaballero.commandlambda13;

import com.icaballero.sorting01.Factura;

public class CommandManager {

	public static Factura guardar(Factura factura) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("guardando la factura " + factura.getNumero());

		return factura;

	}

	public static Factura imprimir(Factura factura) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(factura.getNumero());
		System.out.println(factura.getConcepto());
		System.out.println(factura.getImporte());

		return factura;

	}

	public static Factura email(Factura factura) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("enviando por email la factura " + factura.getNumero());

		return factura;

	}

}
