package com.blah.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeveltestController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/leveltest")
	public String board(Locale locale, Model model) {
		logger.info("into the leveltest");
		
		return "leveltest/leveltestStart";
	}
}
