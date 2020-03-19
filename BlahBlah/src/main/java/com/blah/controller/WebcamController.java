package com.blah.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebcamController {
	@RequestMapping(value = "chatting", method = RequestMethod.GET)
	public String goViewChatting(HttpServletRequest request) {
		try {
			String userId = request.getParameter("userId");
			System.out.println(userId+" 유저 입장");
			
		} catch (Exception e) {
			System.out.println("채팅 들어가기 전에 유저 널값 !! ");
		}
		
		return "lesson/chatting";
	}
}
