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
		
		
		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(vo));
		mav.addObject("closedmyclassList", service.selectClosedMyClass(vo));
		mav.addObject("member", service.selectMember(vo));
		mav.addObject("progressList", service.selectProgress(vo));
		
		return mav;
	}
	
	
	@RequestMapping(value="/uploadProfile")
	public String uploadProfile(HttpServletRequest request, HttpSession session, Model model, FilesVo uploadFile) {
		// BindingResult : 객체를 Binding하다 에러가 발생하면 해당 에러의 정보를 받기위해 사용된다.
		logger.info("chageProfile");
		MemberVo vo = (MemberVo) session.getAttribute("login");
		
		service.uploadProfile(request,session,uploadFile,vo);
		
		model.addAttribute("member", service.selectMember(vo));
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
	
//	@RequestMapping(value = "/deleteMember")
//	public String deleteUser(HttpSession session, Model model, MemberVo memVo) {
//		logger.info("deleteMember");
//		MemberVo vo = (MemberVo)session.getAttribute("login");
//		System.out.println(memVo.getMemberPw());
//		
//		Map<String, Boolean> map = service.deleteMember(vo, memVo.getMemberPw()); 
//		return "common/main";
//	}
	@RequestMapping(value = "/deleteMember",produces = "application/text; charset=utf8")
	@ResponseBody
	public Map<String, Boolean> deleteUser(HttpSession session, @RequestBody Map<String, String> deleteval) {
		logger.info("deleteMember");
		MemberVo vo = (MemberVo)session.getAttribute("login");
		System.out.println(vo +",,,,"+deleteval.get("delpw"));
		
		Map<String, Boolean> map = service.deleteMember(vo, deleteval.get("delpw")); 
		System.out.println("map : "+map);
		return map;
	}
	
	@RequestMapping(value = "/lessonRoom")
	public String lessonRoom (Model model, int lessonNo) {
		logger.info("lessonRoom");
		
//		model.addAllAttributes("vo",service.selectOneLesson(lessonNo));

		return "mypage/mypageLessonRoom";
	}


}
