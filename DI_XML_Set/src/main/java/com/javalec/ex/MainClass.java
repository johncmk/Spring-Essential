package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Config Location
		String config_1 = "classpath:applicationCTX.xml"; 
		String config_2 = "classpath:applicationCTX1.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config_1, config_2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("student1: " + student1.getName());
		System.out.println("student1: " + student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1" , StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println("student2: " + student2.getName());
		System.out.println("student2: " + student2.getHobbys());
		
		//They are equal because the student variable that is declared in studentInfo class
		//has reference to the bean where id is "student1" which is being used as a student1
		//variable here. Therefore both student1 and student2 are pointing to the 
		//same referenced object. This action provides same property/attribute to 
		//both student1 and student2.
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		student1.setName("Foo");
		
		System.out.println("====================");
		System.out.println("Student1 Name "+student1.getName());
		System.out.println("Student1 Hobbys "+student1.getHobbys());
		System.out.println("Student2 Name "+student2.getName());
		System.out.println("Student2 Hobbys "+student2.getHobbys());
		System.out.println("====================");
		
		Student student3 = ctx.getBean("student3" , Student.class);
		System.out.println(student3.getName());
		
		//They are not equal because they are not pointing to the same reference.
		//student1 is pointing to the bean where id is "student1"
		//and student2 is point to the bean where id is "student2".
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamaName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
		
	}//End Main

}//End Class
