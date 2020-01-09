package com.icaballero.composite;

public class CuentaAhorro implements CuentaComponent {

	private Double amount;
	private String name;
	
	
	
	public CuentaAhorro(Double amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	@Override
	public void showAccountName() {
		System.out.println("Cuenta Ahorro: "+name);
	}

	@Override
	public Double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

}
