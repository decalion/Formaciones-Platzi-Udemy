package com.icaballero.app.beans;

public class EmailService implements IEmailService {
	
	
	private Saludator saludator;
	
	public void setSaludator(Saludator saludator) {
		this.saludator = saludator;
	}


	@Override
	public void enviarEmailSaludo(String str) {
		System.out.println("Enviando email a " + str);
		System.out.println("Mensaje: " + saludator.saludo());
		
	}

}
