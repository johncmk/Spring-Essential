package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();//생성 Constructor
		
		ctx.load("classpath:applicationCTX.xml"); //설정 Setting
		ctx.refresh(); //설정
		
		Student student = ctx.getBean("student", Student.class); //사용 Use
		System.out.println("Name: " + student.getName()); //사용
		System.out.println("Age: " + student.getAge()); //사용
		
		ctx.close(); //종료 Terminate
		
	}

}
