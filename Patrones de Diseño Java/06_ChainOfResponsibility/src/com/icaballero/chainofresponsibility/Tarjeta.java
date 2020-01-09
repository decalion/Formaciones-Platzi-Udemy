package com.icaballero.chainofresponsibility;

public class Tarjeta implements ApproveLoanChain {

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
		Gold gold = new Gold();
		this.serNext(gold);
		
		Platinum platinum = new Platinum();
		gold.serNext(platinum);
		
		Black black = new Black();
		platinum.serNext(black);
		
		next.creditCardRequest(totalLoan);
		
	}
	
	
	

}
