package com.blah.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/mypage")
	public ModelAndView main(Model model) {
		logger.info("Mypage");
		
		String memberId = "UESR3";
		
		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("lesson",service.selectMyClass(memberId));
		System.out.println(service.selectMyClass(memberId));
		return mav;
	}
}
