package com.icaballero.composite;

import java.util.ArrayList;
import java.util.List;

public class CuentaComposite implements CuentaComponent {

	private List<CuentaComponent> list = new ArrayList<>();
	
	
	
	
	@Override
	public void showAccountName() {
		for (CuentaComponent cuentaComponent : list) {
			cuentaComponent.showAccountName();
		}
		
	}

	@Override
	public Double getAmount() {
		Double amount = 0.0;
		for (CuentaComponent cuentaComponent : list) {
			amount+=cuentaComponent.getAmount();
		}
		return amount;
	}
	
	
	
	public void addCuenta(CuentaComponent cuenta) {
		list.add(cuenta);
	}
	
	public void removeCuenta(CuentaComponent cuenta) {
		list.remove(cuenta);
	}

}
