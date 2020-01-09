package com.icaballero.main;

import com.icaballero.observer.Coche;
import com.icaballero.observer.MessagePublisher;
import com.icaballero.observer.Peaton;
import com.icaballero.observer.Semaforo;

public class Main {
	
	public static void main(String[] args) {
		probarObserver();
		
	}
	
	
	private static void probarObserver() {
		Coche coche = new Coche();
		Peaton peaton = new Peaton();
		MessagePublisher messagePub = new MessagePublisher();
		messagePub.attach(peaton);
		messagePub.attach(coche);
		messagePub.notifyUpdate(new Semaforo("ROJO_COCHE"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		messagePub.notifyUpdate(new Semaforo("VERDE_COCHE"));
		
	}

}
