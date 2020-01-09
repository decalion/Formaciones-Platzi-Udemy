package com.icaballero.state;

public class Silent implements MobileAlertState {

	@Override
	public void alert(MobiliAlertStateContext context) {
		System.out.println("Silencio...Pantalla Iluminado...");
		
	}

}
