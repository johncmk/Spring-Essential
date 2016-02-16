package com.javalec.get_post;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.student.Student;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/student")
	public String goStudent(HttpServletRequest request, Model model) {
		
		System.out.println("RequestMethod.GET");
		
		String id = request.getParameter("id");
		System.out.println("id: " + id);
		model.addAttribute("studentId",id);
		return "student/studentId";
	}

	//Post version
//	@RequestMapping(method=RequestMethod.POST, value="/student")
//	public String goStudent(HttpServletRequest request, Model model) {
//		
//		System.out.println("RequestMethod.POST");
//		
//		String id = request.getParameter("id");
//		System.out.println("id: " + id);
//		model.addAttribute("studentId",id);
//		return "student/studentId";
//	}

	/*
	 * Post version overload method
	 */
	@RequestMapping(method=RequestMethod.POST, value="/student")
	public ModelAndView goStudent(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Student st = new Student();
		st.setName("John Smith");
		st.setId(id);
		st.setPw(pw);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/studentId");
		mv.addObject("studentInfo", st);
		
		return mv;
	}
	
}//End
