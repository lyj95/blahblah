package com.blah.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LeveltestService;
import com.blah.vo.LeveltestVo;

@Controller
public class LeveltestController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	
	@RequestMapping(value = "/leveltestStart")
	public String startLeveltest(Locale locale, Model model) {
		
		logger.info("Start leveltest?");
	
		return "leveltest/leveltestStart";
	}
	
	
	@RequestMapping(value = "/leveltest")
	public ModelAndView leveltest(Model model,LeveltestVo vo,HttpSession session) {
		logger.info("leveltest");
			
		ModelAndView mav = new ModelAndView("leveltest/leveltest");
				
		return mav;
	}
	
	@RequestMapping(value = "/leveltestResult")
	public ModelAndView leveltestResult(Model model,LeveltestVo vo,HttpSession session) {
		logger.info("leveltest Result");
			
		ModelAndView mav = new ModelAndView("leveltest/leveltestResult");
				
		return mav;
	}
	
}
