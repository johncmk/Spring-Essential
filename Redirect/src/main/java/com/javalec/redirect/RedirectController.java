package com.javalec.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest request, Model model) {
		
		
		String id = request.getParameter("id");

		if(id.equals("john"))
			return "redirect:studentOk";
		else
			return "redirect:studentNg";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "student/studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "student/studentOk";
	}
	
	//You can also use full URL, but it's not the smart way to do it
	@RequestMapping("/studentURL1")
	public String studentURL1 ( Model model ) {
		return "redirect:http://localhost:8282/redirect/studentURL1.jsp";
	}
	
}//End
