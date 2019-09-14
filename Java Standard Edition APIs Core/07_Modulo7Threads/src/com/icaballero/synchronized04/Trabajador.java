package com.icaballero.synchronized04;

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
		
		this.dias = this.dias +1;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.dias;
	}
	
	

}
