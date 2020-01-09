package com.icaballero.bridge;

public class UnSecureCreditCard implements ICreditCard {

	@Override
	public void realizarPago() {
		System.out.println("Pago Realizado SIN SEGURIDAD");
		
	}

}
