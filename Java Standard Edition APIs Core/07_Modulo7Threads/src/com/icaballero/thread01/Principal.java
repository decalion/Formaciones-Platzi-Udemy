package com.icaballero.thread01;

public class Principal {

	public static void main(String[] args) {
		
		Tarea t = new Tarea("A");
		Tarea t2 = new Tarea("B");
		Tarea t3 = new Tarea("C");
		t2.start();
		t.start();
		t3.start();
		

	}

}
