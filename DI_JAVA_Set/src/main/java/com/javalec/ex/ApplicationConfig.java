package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("Swim");
		hobbys.add("Read");
		
		Student student = new Student("John", 28, hobbys);
		student.setHeight(191);
		student.setWeight(85);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("Soccer");
		hobbys.add("Computer");
		
		Student student = new Student("Tom", 28, hobbys);
		student.setHeight(166);
		student.setWeight(55);
		
		return student;
	}
	
}//End
