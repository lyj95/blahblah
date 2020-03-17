package com.blah.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
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
import com.blah.service.LeveltestService;
import com.blah.service.ScheduleService;
import com.blah.service.UserService;
import com.blah.vo.FeedbackVo;
import com.blah.vo.FilesVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	@Autowired
	private ScheduleService sservice;
	@Autowired
	private LeveltestService lservice;
	
	
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(Model model, HttpSession session) {
		logger.info("Mypage");
		
		MemberVo vo = (MemberVo)session.getAttribute("login");
		String memberId = vo.getMemberId();		
		String type = (String)session.getAttribute("memberType");
		
		
		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(vo));
		mav.addObject("closedmyclassList", service.selectClosedMyClass(vo));
		mav.addObject("member", service.selectMember(vo));
		mav.addObject("progressList", service.selectProgress(vo));
		mav.addObject("clist", sservice.selectCalendar(memberId));
		System.out.println("캘린더 체크 : "+sservice.selectCalendar(memberId));
//		mav.addObject("tutorPhotoList", service.selectTutorPhoto(vo));
		mav.addObject("favList", service.selectFav(memberId));
		mav.addObject("memberLevel", lservice.selectLevel(memberId));
		
		if(type.equals("TUTOR")) { //강사 캘린더
			String tutorId = vo.getMemberId();	
			System.out.println("강사 아이디 : "+tutorId);
			mav.addObject("tutorClist", sservice.selectTutorCalendar(tutorId));
		}
		
		
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
	
	@RequestMapping(value = "/deleteMember",produces = "application/text; charset=utf8")
	@ResponseBody
	public String deleteUser(HttpSession session, @RequestBody Map<String, String> deleteval) {
		logger.info("deleteMember");
		MemberVo vo = (MemberVo)session.getAttribute("login");
		
		String res = service.deleteMember(vo, deleteval.get("delpw")); 
		System.out.println(res);
		return res;
	}
	
	@RequestMapping(value = "/lessonRoom")
	public String lessonRoom (HttpSession session, int lessonNo, Model model) {
		logger.info("lessonRoom");
		String userId = (String)session.getAttribute("userID");
		MemberVo user = (MemberVo)session.getAttribute("login");
		
		HashMap<String, Object> lesson = service.getLessonInfo(lessonNo,userId);
		
		try {
			String studentId = (String)lesson.get("MEMBER_ID");
			List<FeedbackVo> feedback = service.selectFeedback(lessonNo,studentId);
			model.addAttribute("feedback", feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("progress", service.getProgress(lessonNo,user));
		model.addAttribute("lesson", lesson);
		
		return "mypage/mypageLessonRoom";
	}
	
	@RequestMapping(value="/insertFeedback", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String insertFeedback(HttpSession session, FeedbackVo feedbackVo) {
		System.out.println(feedbackVo.toString());
		String userId = (String)session.getAttribute("userID");
		String msg = "피드백 작성을 실패했습니다."; 
		int success = service.insertFeedback(feedbackVo, userId);
		if(success>0) {
			msg = "피드백 작성을 성공했습니다.";
		}
		System.out.println(msg+" : feedback");
		return msg;
	}
	
	@RequestMapping(value="/updateFeedback", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String updateFeedback(HttpSession session, FeedbackVo vo){
		System.out.println("업데이트 용 : "+vo.toString());
		String userId = (String)session.getAttribute("userID");
		String msg = "피드백 수정을 실패했습니다."; 
		int success = service.updateFeedback(vo, userId);
		if(success>0) {
			msg = "피드백 수정을 성공했습니다.";
		}
		System.out.println(msg+" : feedback");
		return msg;
	}
}
