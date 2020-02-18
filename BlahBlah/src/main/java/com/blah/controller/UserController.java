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

import com.blah.service.UserService;
import com.blah.vo.MemberVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/* HttpServletRequest request; */

	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(Model model, HttpSession session) {
		logger.info("Mypage");
		
		MemberVo vo = (MemberVo)session.getAttribute("login");
		
		String memberId = vo.getMemberId();
		System.out.println(vo);

//		String memberId = "user";
		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(memberId));
		mav.addObject("closedmyclassList", service.selectMyClass(memberId));
		mav.addObject("memberList", service.selectMember(memberId));
		mav.addObject("progressList", service.selectProgress(memberId));
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, MemberVo vo) {
		logger.info("deleteUser");
		
		//TODO sessoin에서 ID 가져오기
		String memberId = "user";
		
		return "common/main";
	}
	
	@RequestMapping(value = "/lessonRoom")
	public String lessonRoom (Model model) {
		logger.info("into the lesson");
		
		return "mypage/mypageLessonRoom";
	}
	
	

}
