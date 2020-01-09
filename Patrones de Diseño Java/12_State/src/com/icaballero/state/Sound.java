package com.icaballero.state;

public class Sound implements MobileAlertState{

	@Override
	public void alert(MobiliAlertStateContext context) {
		
		System.out.println("Ring...Ring...");
		
	}

}
