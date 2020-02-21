package com.blah.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blah.common.validate.FileValidate;
import com.blah.service.UserService;
import com.blah.vo.FilesVo;
import com.blah.vo.MemberVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(Model model, HttpSession session) {
		logger.info("Mypage");
		
		MemberVo vo = (MemberVo)session.getAttribute("login");
		String memberId = vo.getMemberId();
		System.out.println(vo);


		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(memberId));
		mav.addObject("closedmyclassList", service.selectMyClass(memberId));
		mav.addObject("member", service.selectMember(memberId));
		mav.addObject("progressList", service.selectProgress(memberId));
		
		return mav;
	}
	
	
	@RequestMapping(value="/uploadProfile")
	public String uploadProfile(HttpServletRequest request, HttpSession session, Model model, FilesVo uploadFile) {
		// BindingResult : 객체를 Binding하다 에러가 발생하면 해당 에러의 정보를 받기위해 사용된다.
		logger.info("chageProfile");
		MemberVo vo = (MemberVo) session.getAttribute("login");
		System.out.println(uploadFile);
		
		service.uploadProfile(request,session,uploadFile,vo);
		
		model.addAttribute("member", service.selectMember(vo.getMemberId()));
		return "mypage/mypage";
	}
	
	
	@RequestMapping(value="/changePw", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> changePw(HttpSession session, @RequestBody HashMap<String, String> hmap){
		logger.info("changePw");
		MemberVo vo = (MemberVo) session.getAttribute("login");
		
		Map<String, Boolean> map = service.changePw(vo, hmap);
		
		return map;
	}
	
	@RequestMapping(value = "/deleteMember",produces = "application/text; charset=utf8")
	@ResponseBody
	public Map<String, Boolean> deleteUser(Model model, String nowpw, HttpSession session) {
		logger.info("deleteMember");
		MemberVo vo = (MemberVo)session.getAttribute("login");
		
		Map<String, Boolean> map = service.deleteMember(vo, nowpw); 
		
		return map;
	}
	
	@RequestMapping(value = "/lessonRoom")
	public String lessonRoom (Model model) {
		logger.info("into the lesson");
		
		return "mypage/mypageLessonRoom";
	}


}
