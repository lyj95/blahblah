package com.blah.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebcamController {
	// https://192.168.130.31:8443/controller/chatting?userId=13212
	@RequestMapping(value = "chatting", method = RequestMethod.GET)
	public String goViewChatting(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		System.out.println(userId+" 유저 입장");
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
		return "lesson/chatting";
	}
}
