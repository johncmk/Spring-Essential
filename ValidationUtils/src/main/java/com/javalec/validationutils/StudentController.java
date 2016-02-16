package com.javalec.validationutils;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student,
								BindingResult res) {
		
		String page = "createDonePage";
		
		StudentValidator v = new StudentValidator();
		v.validate(student, res);
		
		if(res.hasErrors()) {
			page = "createPage";
		}
		
		return page;
		
	}
	
}
