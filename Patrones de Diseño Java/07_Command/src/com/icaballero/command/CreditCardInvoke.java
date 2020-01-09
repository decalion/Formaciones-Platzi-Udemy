package com.icaballero.command;

public class CreditCardInvoke {

	
		private Command command;
		
		public CreditCardInvoke() {
			
		}
		
		

		public void run() {
			command.execute();
		}

		public void setCommand(Command command) {
			this.command = command;
		}
		
		
		
}
