package com.icaballero.command;

public class CreditCard {
	
	public void sendPinNumberToCustomer() {
		
		System.out.println("El pun number ha sido enviado al cliente.");
	}
	
	public void sendSMSToCustomerActivate() {
		
		System.out.println("Enviado SMS al cliente informando que su tarjeta ha estdo activada.");
	}

	public void activate() {
		
		System.out.println("La Tarjeta ha sido activada");
	}

	public void desactivate() {
		
		System.out.println("La tarjeta ha sido desactivada");
		
	}
	
	public void sendSMSToCustomerDesactivate() {
		
		System.out.println("Enviado SMS al cliente informando que su tarjeta ha sido desactivada");
	}

}
