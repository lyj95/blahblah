package com.blah.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.AccountService;

import com.blah.vo.MemberVo;
import com.github.scribejava.core.model.OAuth2AccessToken;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class AccountController {
	private Logger logger = LoggerFactory
					.getLogger(AccountController.class);
	@Autowired
	private AccountService service;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value="/login")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "/account/login";
	}
	
	@RequestMapping(value="ajaxlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberVo vo){
		//ResponseBody: java객체를 response객체에 바인딩
		//RequestBoey: request객체로 넘어오는 데이터를 java 객체로
		MemberVo res = service.login(vo);
		boolean check = false;

		String userID = res.getMemberId();
		String memberType = res.getMemberType();
		
		if(res != null) {
			session.setAttribute("login", res);
			session.setAttribute("userID", userID);
			session.setAttribute("memberType", memberType);
			check=true;

		}

		if(passwordEncoder.matches(vo.getMemberPw(), res.getMemberPw())) {		//암호화된 비번이랑 원래 비번이랑 같은지 비교
			session.setAttribute("login", res);
			check = true;

		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;

	}

	@RequestMapping(value="signupform")
	public String signupForm() {
		logger.info("signup FORM");
		return "/account/signup";
	}
	@RequestMapping(value="signup")
	public String signup(MemberVo vo) {
		logger.info("signup");

		vo.setMemberPw(passwordEncoder.encode(vo.getMemberPw()));
		
		if(service.signup(vo)>0) {
			return "redirect:login";
		} else {
			return "redirect:signupform";
		}
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
	
	 @RequestMapping("logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "common/main";
	    }
	
	 @RequestMapping("findidform")
		public String findidForm() {
			logger.info("findid FORM");
			return "/account/findID";
		}	
	 @RequestMapping("account/memberSearchIdEnd.do")
		public ModelAndView idSearchEnd(String memberName, String memberEmail) {
			ModelAndView mv= new ModelAndView();
			Map<String,String> map=new HashMap();
			map.put("memberName",memberName);
			map.put("memberEmail",memberEmail);
			map=service.selectSearchId(map);
			
			String msg="";
			if(map!=null)
			{
				String memberId=map.get("MEMBER_ID");
				msg="회원님의 아이디는 " + memberId+" 입니다." ;
				
			}
			else
			{
				msg="찾으시는 아이디가 없습니다";
			}
			String loc="/login";
			mv.addObject("loc",loc);
			mv.addObject("msg",msg);
			mv.setViewName("common/msg");
			return mv;
			
			
		}
	 
	 @RequestMapping("findpwform")
		public String findpwForm() {
			logger.info("findpw FORM");
			return "/account/findPwd";
		}	
	 
	 @RequestMapping("account/memberSearchPwEnd.do")
		public ModelAndView pwSearchEnd(String memberName, String memberId, String memberEmail) {
			ModelAndView mv= new ModelAndView();
			Map<String,String> map=new HashMap();
			map.put("memberName",memberName);
			map.put("memberEmail",memberEmail);
			map.put("memberId",memberId);
			map=service.selectSearchPw(map);
			
			String msg="";
			if(map!=null)
			{
				String memberPw=map.get("MEMBER_PW");
				msg="회원님의 비밀번호는 " + memberPw+" 입니다." ;
				
			}
			else
			{
				msg="아이디,이름,이메일을 다시 확인해주세요";
			}
			String loc="/login";
			mv.addObject("loc",loc);
			mv.addObject("msg",msg);
			mv.setViewName("common/msg");
			return mv;
			
			
		}
	 
	 /* NaverLoginBO */
	    private NaverLoginBO naverLoginBO;
	    private String apiResult = null;
	    
	    @Autowired
	    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
	        this.naverLoginBO = naverLoginBO;
	    }
	  //로그인 첫 화면 요청 메소드
	    @RequestMapping(value = "/naverLogin", method = { RequestMethod.GET, RequestMethod.POST })
	    public String login(Model model, HttpSession session) {
	        
	        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
	        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	        
	        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
	        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
	        System.out.println("네이버:" + naverAuthUrl);
	        
	        //네이버 
	        model.addAttribute("url", naverAuthUrl);
	 
	        /* 생성한 인증 URL을 View로 전달 */
	        return "naverLogin";
	    }
	 
	    //네이버 로그인 성공시 callback호출 메소드
	    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
	            throws IOException {
	        System.out.println("여기는 callback");
	        OAuth2AccessToken oauthToken;
	        oauthToken = naverLoginBO.getAccessToken(session, code, state);
	        //로그인 사용자 정보를 읽어온다.
	        apiResult = naverLoginBO.getUserProfile(oauthToken);
	        model.addAttribute("result", apiResult);
	 
	        /* 네이버 로그인 성공 페이지 View 호출 */
	        return "naverLogin";
	    }
	}



