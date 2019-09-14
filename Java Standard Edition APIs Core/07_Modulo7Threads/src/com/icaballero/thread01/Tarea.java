package com.icaballero.thread01;

public class Tarea extends Thread {

	
	
	
	
	public Tarea(String name) {
		super(name);
		
	}

	@Override
	public void run() {
	
		for (int i = 0; i <5; i++) {
			
			
			try {

				System.out.println("Hola tarea :"+this.getName()+" Iteracion: " + i);
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
	}

}
