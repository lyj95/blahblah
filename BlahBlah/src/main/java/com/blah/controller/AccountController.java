package com.blah.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.blah.service.AccountService;

import com.blah.vo.MemberVo;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class AccountController {
	private Logger logger = LoggerFactory
					.getLogger(AccountController.class);
	@Autowired
	private AccountService service;
//	
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;
	
	
	
	@RequestMapping(value="/login")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "/account/login";
	}
	
	@RequestMapping(value="ajaxlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, 
			@RequestBody MemberVo vo, Model model){
		//ResponseBody: java객체를 response객체에 바인딩
		//RequestBoey: request객체로 넘어오는 데이터를 java 객체로
		MemberVo res = service.login(vo);
		boolean check = false;
		
		if(res != null) {
			session.setAttribute("login", res);
			check=true;
		}
		
		Map<String, Boolean> map = 
				new HashMap<String, Boolean>();
		map.put("check", check);
		
		
		return map;
	}

	@RequestMapping("signupform")
	public String signupForm() {
		logger.info("signup FORM");
		return "/account/signup";
	}
	
	@RequestMapping(value="idchk")
	@ResponseBody
	public void idchk(HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		String paramId= (request.getParameter("memberId") == null)?"":String.valueOf(request.getParameter("memberId"));
		String checkId = service.idchk(paramId);
		out.print(checkId);
	
		out.flush();
		out.close();
	}



	

////
//	@RequestMapping("/signup")
//	public String memberInsert(AccountVo vo) {
//		//화명에서 넘어운 pw 암호화
//		vo.setMemberPw(passwordEncoder.encode(vo.getMemberPw()));
//		
//		System.out.println("인코딩된 비밀번호"+vo.getMemberPw());
//		
//		if(service.insert(vo)>0) {
//			return "redirect:loginform.do";
//		} else {
//			return "redirect:registerform.do";
//		}
//	}
	
	
	
	
	
	
	
	
}
