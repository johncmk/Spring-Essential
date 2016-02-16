package com.javalec.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0); // Class that is being validated.
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		System.out.println("validate()");
		
		Student student = (Student) obj;
		
		String student_name = student.getName();
		
		if(student_name == null || student_name.trim().isEmpty()) {
			System.out.println("Student Name is null or empty");
			errors.rejectValue("name", "trouble");
		}
		
		int student_id = student.getId();
		
		if(student_id == 0) {
			System.out.println("student ID is 0");
			errors.rejectValue("id", "trouble");
		}
	}

	
	
}//End
