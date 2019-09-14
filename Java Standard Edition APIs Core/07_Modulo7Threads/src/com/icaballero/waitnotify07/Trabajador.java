package com.icaballero.waitnotify07;

public class Trabajador {
	
	private int dias;
	
	
	

	public Trabajador(int dias) {
		super();
		this.dias = dias;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
	public synchronized int addDia() {
		
		
		
		try {
			//Decimos que el hilo espere 2 segunos
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dias = this.dias +1;
		
		//Notificamos al resto de hilos que ya se ha actualizado el valor
		notifyAll();
		
		return this.dias;
	}
	
	

}
