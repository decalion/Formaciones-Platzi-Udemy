package com.icaballero.state;

public class Vibration implements MobileAlertState {

	@Override
	public void alert(MobiliAlertStateContext context) {
		System.out.println("Vibrando...Vibrando...");
		
	}

}
