package com.icaballero.mediator;

public class ConcreteMediator implements Mediator {

	private ConcreteCollege1 user1;
	private ConcreteColleage2 user2;
	
	
	
	public void setUser1(ConcreteCollege1 user) {
		this.user1 = user;
	}
	
	public void setUser2(ConcreteColleage2 user) {
		this.user2 = user;
	}
	
	
	@Override
	public void send(String message, Colleage colleage) {
		if(colleage == user1) {
			user2.messageReceived(message);
		}else if(colleage == user2) {
			user1.messageReceived(message);
		}
		
	}

}
