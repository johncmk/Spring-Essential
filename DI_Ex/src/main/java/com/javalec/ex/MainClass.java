package com.javalec.ex;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.SpringVersion;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* This is not SPRING concept execution
		MyCalculator mc = new MyCalculator();
		mc.setCalculation(new Calculator());
		
		mc.setFirstNum(100);
		mc.setSecondNum(10);
		
		mc.add();
		mc.sub();
		mc.div();
		mc.mul();
		*/
		
		//SPRING Setting
		String config = "classpath:applicationCTX.xml"; //config location
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config); 
		
		MyCalculator mc = ctx.getBean("myCalculator" , MyCalculator.class);
//		mc.setFirstNum(100);
//		mc.setSecondNum(100);
		mc.add();
		mc.sub();
		mc.mul();
		mc.div();
		ctx.close();
		
		System.out.println("Spring Ver: " + SpringVersion.getVersion());
		
	}//End main

}//End class
