package com.icaballero.mediator;

public class ConcreteColleage2 extends Colleage {

	public ConcreteColleage2(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void send(String message) {
		mediator.send(message, this);
	
	}

	@Override
	public void messageReceived(String message) {
		System.out.println("El colega2 ha Recibido el siguiente mensaje : " +message);
	
	}
}