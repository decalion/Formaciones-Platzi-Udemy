package com.icaballero.main;

import com.icaballero.state.MobiliAlertStateContext;
import com.icaballero.state.Silent;
import com.icaballero.state.Vibration;

public class Main {
	
	public static void main(String[] args) {
		probarState();
	}
	
	private static void probarState() {
		MobiliAlertStateContext context = new MobiliAlertStateContext();
		context.alert();
		context.alert();
		context.setState(new Vibration());
		context.alert();
		context.alert();
		context.setState(new Silent());
		context.alert();
		context.alert();
		
		
	}

}
