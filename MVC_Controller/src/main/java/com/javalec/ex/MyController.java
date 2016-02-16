package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class MyController {

	@RequestMapping("/write")
	public String write(Model model) {
		
		model.addAttribute("id", 30);
		
		return "/board/write";
	}
	
	
}//End
