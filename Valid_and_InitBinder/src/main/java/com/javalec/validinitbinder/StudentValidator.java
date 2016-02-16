package com.javalec.validinitbinder;

import org.springframework.validation.Errors;

//import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("Validate()");
		Student student = (Student)obj;
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		String student_name = student.getName();
		if(student_name == null || student_name.trim().isEmpty()) {
			System.out.println("Name is null or empty");
			errors.rejectValue("name", "trouble");
		}
		
		
		int student_id = student.getId();
		if(student_id == 0) {
			System.out.println("student_id is 0");
			errors.rejectValue("id", "trouble");
		}
		
	}
}