package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String...strings) {
		
		String config = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		//JAVA File that is injected to XML File
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		System.out.println("Hobby: " + student1.getHobbys());
		System.out.println("Height: " + student1.getHeight());
		System.out.println("Weight: " + student1.getWeight());
		
		//XML File that is written in XML File
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("Name: " + student2.getName());
		System.out.println("Age: " + student2.getAge());
		System.out.println("Hobby: " + student2.getHobbys());
		System.out.println("Height: " + student2.getHeight());
		System.out.println("Weight: " + student2.getWeight());
		
		ctx.close();
	}//End main
}//End Class
