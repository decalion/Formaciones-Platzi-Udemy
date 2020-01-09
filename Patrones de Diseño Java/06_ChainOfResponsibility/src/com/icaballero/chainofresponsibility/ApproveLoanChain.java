package com.icaballero.chainofresponsibility;

public interface ApproveLoanChain {
	
	void serNext(ApproveLoanChain loan);
	ApproveLoanChain getNext();
	void creditCardRequest(int totalLoan);

}
