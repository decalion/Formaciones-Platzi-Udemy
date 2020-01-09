package com.icaballero.state;

public class MobiliAlertStateContext {
	
	private MobileAlertState currentState;
	
	public MobiliAlertStateContext() {
		currentState = new Sound();
	}

	public void setState(MobileAlertState state) {
		currentState = state;
	}
	
	
	public void alert() {
		currentState.alert(this);
	}
	
}
