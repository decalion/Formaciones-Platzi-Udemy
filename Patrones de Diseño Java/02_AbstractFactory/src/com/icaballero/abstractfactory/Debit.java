package com.icaballero.abstractfactory;

public class Debit  implements PaymentMethod{

	@Override
	public String doPayment() {
		// TODO Auto-generated method stub
		return "Pago a Debito";
	}

}
