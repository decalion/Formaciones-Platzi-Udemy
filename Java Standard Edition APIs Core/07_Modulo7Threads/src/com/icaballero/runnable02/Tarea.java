package com.icaballero.runnable02;

public class Tarea implements Runnable {

	
	
	
	

	@Override
	public void run() {
	
		for (int i = 0; i <5; i++) {
			
			
			try {

				System.out.println("Hola tarea :"+Thread.currentThread().getName()+" Iteracion: " + i);
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
	}

}
