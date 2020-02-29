package com.blah.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// controller 실행 요청 전에 수행
	// return true; => 컨트롤러 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("[interceptor] : preHandle");
		System.out.println("인터셉터 실행!!!!!!");

		if (request.getRequestURI().contains("/login")
				|| request.getRequestURI().contains("/ajaxlogin")
				|| request.getRequestURI().contains("/main")
				|| request.getRequestURI().contains("/lessonRoom")		// 테스트용
				|| request.getRequestURI().contains("/chatting")
				|| request.getRequestURI().contains("/signup")
				|| request.getRequestURI().contains("/courseList")
				|| request.getRequestURI().contains("/notice")
				|| request.getRequestURI().contains("/noticeDetail")
				|| request.getRequestURI().contains("/noticeOrderByNoticeView")
				|| request.getRequestURI().contains("/searchByTitle")
				|| request.getRequestURI().contains("/searchByContent")
				|| request.getRequestURI().contains("/qna")
				|| request.getRequestURI().contains("/qnaDetail")
				|| request.getRequestURI().contains("/openLockedQnaDetail")
				|| request.getRequestURI().contains("/searchByQnaTitle")
				|| request.getRequestURI().contains("/searchByQnaContent")
				|| request.getRequestURI().contains("/idchk")
				|| request.getRequestURI().contains("/findpwform")
				|| request.getRequestURI().contains("/findidform")
				|| request.getRequestURI().contains("/signupform")
				|| request.getRequestURI().contains("/naverLogin")
				|| request.getRequestURI().contains("/callback")
				|| request.getRequestURI().contains("/kakaoLogin")){
	
			return true;

		}

		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("login");
			return false;
		}

		if (request.getSession().getAttribute("login") != null) {
			return true;
		}

		return false;
	}


	// view로 forward 되기전에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[interceptor] : postHandle");
	}

	// view까지 처리 끝난후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[interceptor] : afterCompletion");
	}

}
