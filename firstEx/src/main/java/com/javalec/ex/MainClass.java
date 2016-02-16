package com.javalec.ex;

public class MainClass {

	
	public static void main(String... args) {
		Calculation cal = new Calculation();
		
		cal.setFirstNum(100);
		cal.setSecondNum(10);

		cal.add();
		cal.div();
		cal.mult();
		cal.sub();
	}
}
