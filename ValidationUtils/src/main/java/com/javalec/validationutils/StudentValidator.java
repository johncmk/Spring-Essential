package com.javalec.validationutils;

import org.springframework.validation.Errors;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {
		// TODO Auto-generated method stub
		
		System.out.println("validate()");
		
		Student student = (Student)obj;
		
//		String studentName = student.getName();
//		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName is null or Empty");
//			arg1.rejectValue("name", "trouble");
//		}

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "trouble");
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			err.rejectValue("id", "trouble");
		}
		
	}

}
