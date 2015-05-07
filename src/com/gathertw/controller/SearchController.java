package com.gathertw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Status;

import com.gathertw.twitter.TwitterUtil;

@Controller
public class SearchController {
	
	/**
	 * Collects the value of the main form and contacts with the Twitter API.
	 */
	@RequestMapping("/processSearch")
	public ModelAndView generateResults(HttpServletRequest request, HttpServletResponse response) {
	 
		String q = request.getParameter("q");
		
		TwitterUtil twitter = new TwitterUtil();
		List<Status> results = twitter.getTweetsFromKeyWord(q);
		
		ModelAndView mav = new ModelAndView("results");
		
		mav.addObject("results", results);
		
		return mav;
	}
}
