package com.blah.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login")
	public String login(Locale locale, Model model) {
		logger.info("into the login");
		
		return "account/login";
	}
	
	@RequestMapping(value = "/signup")
	public String signup(Locale locale, Model model) {
		logger.info("into the signup");
		
		return "account/signup";
	}
}
