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
		hobbys.add("Cook");
		
		Student st1 = new Student("John", 28, hobbys);
		st1.setHeight(191);
		st1.setWeight(84);
		
		return st1;
	}
	
}
