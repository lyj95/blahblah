package com.blah.controller;

import java.text.DateFormat;
import java.util.Date;

import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LessonService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LessonService service;
	
	@RequestMapping(value = "/main")
	public ModelAndView main(Locale locale) {
		logger.info("Welcome main! The client locale is {}.", locale);
		logger.info("메인입장"); 
		ModelAndView mav = new ModelAndView("common/main");
		mav.addObject("reviewlist", service.selectLatestReview());
		mav.addObject("lessonlist", service.selectPopularLesson());
		System.out.println(service.selectLatestReview());



		return mav;

	}



}
