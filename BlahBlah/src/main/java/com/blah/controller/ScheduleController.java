package com.blah.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.ScheduleService;

@Controller
public class ScheduleController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ScheduleService sservice;
	
	@RequestMapping(value = "/calendar")
	public ModelAndView showCalendar(HttpServletRequest request, Model model) {
		logger.info("calendar");
		
		//TODO sessoin에서 ID 가져오기
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("MemberId");
		
		ModelAndView mav = new ModelAndView("calendar/calendar");
		mav.addObject("clist", sservice.selectCalendar(memberId));
		
		System.out.println(sservice.selectCalendar(memberId));
		
		return mav;
	}
}
