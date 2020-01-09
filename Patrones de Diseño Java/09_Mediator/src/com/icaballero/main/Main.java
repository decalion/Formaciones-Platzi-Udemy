package com.icaballero.main;

import com.icaballero.mediator.ConcreteColleage2;
import com.icaballero.mediator.ConcreteCollege1;
import com.icaballero.mediator.ConcreteMediator;

public class Main {
	
	public static void main(String[] args) {
		probarMediator();
	}
	
	
	
	private static void probarMediator() {
		ConcreteMediator mediator = new ConcreteMediator(); 
		ConcreteCollege1 user1 = new ConcreteCollege1(mediator);
		ConcreteColleage2 user2 = new ConcreteColleage2(mediator);
		
		mediator.setUser1(user1);
		mediator.setUser2(user2);
		
		user1.send("Hola soy el user1");
		user2.send("Hola user1, soy el user2");
	
	
	}

}
