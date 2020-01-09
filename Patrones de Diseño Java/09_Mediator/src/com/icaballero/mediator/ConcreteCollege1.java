package com.icaballero.mediator;

public class ConcreteCollege1 extends Colleage {

	public ConcreteCollege1(Mediator mediator) {
		super(mediator);
		
	}

	@Override
	public void send(String message) {
		mediator.send(message, this);
		
	}

	@Override
	public void messageReceived(String message) {
		System.out.println("El colega1 ha Recibido el siguiente mensaje : " +message);
		
	}

}
