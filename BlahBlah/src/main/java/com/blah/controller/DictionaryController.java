package com.blah.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blah.service.DictionaryService;

@Controller
public class DictionaryController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DictionaryService service;
	
	@RequestMapping(value = "/search", produces = "application/text; charset=utf8")
	@ResponseBody
	public String search (Model model, String text) throws IOException {
		logger.info("search");
		
		return service.search(text);
		
	}
	@RequestMapping(value = "/dictionary")
	public String dictionary (Model model) {
		logger.info("dictionary");

		return "mypage/dictionary";
	}
}
