package com.icaballero.main;

import com.icaballero.interpreter.AndExpression;
import com.icaballero.interpreter.Expression;
import com.icaballero.interpreter.OrExpression;
import com.icaballero.interpreter.TerminalExpression;

public class Main {
	
	public static void main(String[] args) {
		probarInterpreter();
		
	}
	
	
	private static void probarInterpreter() {
		Expression cero = new TerminalExpression("0");
		Expression uno = new TerminalExpression("1");
		
		Expression orBoolean = new OrExpression(cero, uno);
		Expression containsOneAndCero = new AndExpression(cero, uno);
		
		System.out.println(orBoolean.interpret("cero"));
		System.out.println(orBoolean.interpret("0"));
		System.out.println(orBoolean.interpret("cero"));
		System.out.println(orBoolean.interpret("0"));
	}

}
