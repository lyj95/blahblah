package com.blah.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.UserService;
import com.blah.vo.MemberVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/mypage")
	public ModelAndView main(Model model) {
		logger.info("Mypage");
		
		//TODO sessoin에서 ID 가져오기
		String memberId = "user";
		
		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(memberId));
		mav.addObject("closedmyclassList", service.selectMyClass(memberId));
		mav.addObject("memberList", service.selectMember(memberId));
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, MemberVo vo) {
		logger.info("deleteUser");
		
		//TODO sessoin에서 ID 가져오기
		String memberId = "user";
		
		
		
		return "common/main";
	}
	
}
