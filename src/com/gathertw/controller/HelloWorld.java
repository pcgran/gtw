package com.gathertw.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorld {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
	 
		String message = "Hello world from HelloWorld.java";
		
		ModelAndView mav = new ModelAndView("welcome");
		
		mav.addObject("message", message);
		
		return mav;
	}
}