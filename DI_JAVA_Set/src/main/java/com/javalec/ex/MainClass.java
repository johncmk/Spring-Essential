package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//John
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		System.out.println("Hobby: " + student1.getHobbys());
		System.out.println("Height: " + student1.getHeight());
		System.out.println("Weight: " + student1.getWeight());
		
		//Tom
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("Name: " + student2.getName());
		System.out.println("Age: " + student2.getAge());
		System.out.println("Hobby: " + student2.getHobbys());
		System.out.println("Height: " + student2.getHeight());
		System.out.println("Weight: " + student2.getWeight());
		
		ctx.close();
		
	}//End main
}//End class
