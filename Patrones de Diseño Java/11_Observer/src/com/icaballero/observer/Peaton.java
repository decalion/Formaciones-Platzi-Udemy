package com.icaballero.observer;

public class Peaton implements Observer {

	
	
	@Override
	public void update(Semaforo semaforo) {
		if(semaforo.status.equals("ROJO_COCHE")) {
			System.out.println("Semaforo Verde para Peaton -> Peton puede pasar");
		}else {
			System.out.println("Semaforo Rojo para Peaton -> Peton NO puede pasar");
		}
		
	}

}
