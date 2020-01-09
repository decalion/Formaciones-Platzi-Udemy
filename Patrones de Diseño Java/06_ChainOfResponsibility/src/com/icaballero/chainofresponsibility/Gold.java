package com.icaballero.chainofresponsibility;

public class Gold implements ApproveLoanChain {

	private ApproveLoanChain next;
	
	@Override
	public void serNext(ApproveLoanChain loan) {
		next = loan;
		
	}

	@Override
	public ApproveLoanChain getNext() {
		
		return next;
	}

	@Override
	public void creditCardRequest(int totalLoan) {
		
		if(totalLoan <= 10000) {
			System.out.println("Esta solicitud de tarjeta de credito la maneja la tarjeta Gold");
		}else {
			next.creditCardRequest(totalLoan);
		}
	}

}
