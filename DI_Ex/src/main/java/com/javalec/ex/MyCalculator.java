package com.javalec.ex;

public class MyCalculator {

	Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	public MyCalculator() {
		
	}

	public void add() {
		calculator.addtion(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.subtration(firstNum, secondNum);
	}

	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}

	public void div() {
		calculator.division(firstNum, secondNum);
	}
	
	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	
	
}//End
