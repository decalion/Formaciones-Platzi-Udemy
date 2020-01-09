package com.icaballero.main;

import com.icaballero.composite.CuentaAhorro;
import com.icaballero.composite.CuentaComponent;
import com.icaballero.composite.CuentaComposite;
import com.icaballero.composite.CuentaCorriente;

public class Main {
	
	public static void main(String[] args) {
		probarComposite();
		
	}
	
	
	private static void probarComposite() {
		CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Cuenta Corriente");
	
		CuentaComponent cuentaAhorro = new CuentaAhorro(2000.0, "Cuenta Ahorro");
		
		CuentaComposite composite = new CuentaComposite();
		composite.addCuenta(cuentaCorriente);
		composite.addCuenta(cuentaAhorro);
		
		composite.showAccountName();
		System.out.println(composite.getAmount());
	
	}

}
