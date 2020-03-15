package com.blah.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blah.common.util.KakaoLoginApi;
import com.blah.common.util.MailService;
import com.blah.common.util.NaverLoginBO;
import com.blah.service.AccountService;
import com.blah.vo.MemberVo;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class AccountController {
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountService service;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	@Autowired
	private KakaoLoginApi kakaoLoginApi;
	
	@Autowired
	private MailService mailService;
	
	public void setMailService(MailService mailService) {
	        this.mailService = mailService;
	    }


	@RequestMapping(value = "/login")
	public String loginForm(Model model, HttpSession session) {
		logger.info("LOGIN FORM");

		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		String kakaoUrl = kakaoLoginApi.getAuthorizationUrl(session);

		model.addAttribute("naver_url", naverAuthUrl);
		model.addAttribute("kakao_url", kakaoUrl);

		return "/account/login";
	}

	@RequestMapping(value = "ajaxlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberVo vo) {
		// ResponseBody: java객체를 response객체에 바인딩
		// RequestBoey: request객체로 넘어오는 데이터를 java 객체로
		boolean check = false;

		MemberVo res = service.login(vo);

		if (res != null) {
			if (passwordEncoder.matches(vo.getMemberPw(), res.getMemberPw())) { // 암호화된 비번이랑 원래 비번이랑 같은지 비교
				String userID = res.getMemberId();
				String memberType = res.getMemberType();
				String memberPhoto = res.getMemberPhoto();
				session.setAttribute("login", res);
				session.setAttribute("userID", userID);
				session.setAttribute("memberType", memberType);
				session.setAttribute("memberPhoto", memberPhoto);
				check = true;
			}
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);

		return map;

	}

	@RequestMapping(value = "signupform")
	public String signupForm() {
		logger.info("signup FORM");
		return "/account/signup";
	}

	@RequestMapping(value = "signup")
	public String signup(MemberVo vo) {
		logger.info("signup");

		vo.setMemberPw(passwordEncoder.encode(vo.getMemberPw()));

		if (service.signup(vo) > 0) {
			return "redirect:login";
		} else {
			return "redirect:signupform";
		}
	}

	@RequestMapping(value = "idchk")
	@ResponseBody
	public void idchk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		String paramId = (request.getParameter("memberId") == null) ? ""
				: String.valueOf(request.getParameter("memberId"));
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

	@RequestMapping("account/memberSearchId")
	public ModelAndView idSearchEnd(String memberName, String memberEmail) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> map = new HashMap();
		map.put("memberName", memberName);
		map.put("memberEmail", memberEmail);
		map = service.selectSearchId(map);

		String msg = "";
		if (map != null) {
			String memberId = map.get("MEMBER_ID");
			msg = "회원님의 아이디는 " + memberId + " 입니다.";

		} else {
			msg = "찾으시는 아이디가 없습니다";
		}
		String loc = "/login";
		mv.addObject("loc", loc);
		mv.addObject("msg", msg);
		mv.setViewName("common/msg");
		return mv;

	}

	@RequestMapping("findpwform")
	public String findpwForm() {
		logger.info("findpw FORM");
		return "/account/findPwd";
	}
	
	@RequestMapping(value="/sendMail/password")
	public String sendMailPassword(String memberName, String memberId, String memberEmail, Model model) {
		
		Map<String, String> user = new HashMap();
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberName(memberName);
		user = service.selectEmail(vo);
		
		if (user == null) {
			model.addAttribute("loc", "/findpwform");
			model.addAttribute("msg", "입력하신 아이디 또는 이름이 존재하지 않습니다.");
		
		} else if(!user.get("MEMBER_EMAIL").equals(memberEmail)) {
			model.addAttribute("loc", "/findpwform");
			model.addAttribute("msg", "입력하신 이메일은 가입시 입력하신 이메일과 일치하지 않습니다.");
			
        } else {
        	String newPwd = service.newPwd();
        	vo.setMemberPw(newPwd);
        	int res = service.updatePwd(vo);
        	
        	if(res >0) {
        		System.out.println("임시비밀번호로 비밀번호 변경");
        		StringBuilder sb = new StringBuilder();
        		sb.append("<div align='center' style='border:1px solid black; font-family:verdana'>"); 
        		sb.append("<h3 style='color: gray;'><strong>"+memberId);
        		sb.append("님</strong>의 임시 비밀번호 입니다.<br> 블라블라에 로그인 후 마이페이지에서 비밀번호를 변경하세요.</h3>"); 
        		sb.append("<p>임시 비밀번호 : <strong>" + newPwd + "</strong></p><br><br></div>"); 
        		mailService.send("[blahblah] 임시 비밀번호 발급 안내", sb.toString(), "blahblah.teamproject@gmail.com", memberEmail, null);
        	}
        	
        	model.addAttribute("loc", "/login");
        	model.addAttribute("msg", "회원님의 이메일로 새로운 임시 비밀번호를 발송 하였습니다.");
        }
        return "common/msg";

	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		logger.info("Naver Login");
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터

		MemberVo res = service.naverLogin(apiResult);
		session.setAttribute("login", res);

		return "common/main";
	}

	@RequestMapping(value = "/kakaoLogin")
	public String kakaoLogin(Model model, @RequestParam("code") String code, HttpSession session) throws Exception {
		logger.info("Kakao Login");

		String access_Token = kakaoLoginApi.getAccessToken(code);
		HashMap<String, String> userInfo = kakaoLoginApi.getUserInfo(access_Token);
		System.out.println("login Controller : " + userInfo);

		MemberVo res = service.kakaoLogin(userInfo);
		session.setAttribute("login", res);

		return "common/main";
	}
}
