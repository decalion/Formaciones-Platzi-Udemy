package com.icaballero.adapter06;

public class Principal2 {

	public static void main(String[] args) {
		
		Girable b = new BrazoNormal();
		
		Rotable r = new BrazoAcero();
		
		RobotPro rp = new RobotPro();
		//rp.setBrazoPro(r);
		//rp.rotarBrazoPro();
		rp.setBrazo(new SuperBrazo());
		rp.setBrazoPro(new SuperBrazo());
		rp.girarBrazo();
		rp.rotarBrazoPro();

	}

}
