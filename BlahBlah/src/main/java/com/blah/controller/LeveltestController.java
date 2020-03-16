package com.blah.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LeveltestService;
import com.blah.service.LeveltestServiceImpl;
import com.blah.vo.LeveltestVo;
import com.blah.vo.MemberVo;

@Controller
public class LeveltestController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LeveltestService service = new LeveltestServiceImpl();

	@RequestMapping(value = "/leveltestStart")
	public ModelAndView startLeveltest(HttpSession session) {
		logger.info("Start leveltest?");
		
		MemberVo mvo = (MemberVo)session.getAttribute("login");
		String memberId = mvo.getMemberId();
		
		System.out.println("memberId : "+memberId);
		
		LeveltestVo lvo = service.selectLevel(memberId);
		System.out.println("lvo : "+lvo);
		
		if(lvo == null) {
			ModelAndView mav = new ModelAndView("leveltest/leveltestStart");			
			return mav;
		}else {
			System.out.println("lvo" + lvo);
			
			ModelAndView mav = new ModelAndView("leveltest/leveltestResult");
			mav.addObject("lvo", service.selectLevel(memberId));
			mav.addObject("list", service.selectList(lvo.getMemberLevel()));
			
			return mav;
		}
		
	}

	@RequestMapping(value = "/leveltest")
	public String leveltest() {
		logger.info("leveltest");
		return "leveltest/leveltest";
	}

	
	@RequestMapping(value = "/leveltestResult", method=RequestMethod.POST)
	public ModelAndView leveltestResult(LeveltestVo vo, HttpSession session,
			@RequestParam("q1") int q1, @RequestParam("q2") int q2, 
			@RequestParam("q3") int q3, @RequestParam("q4") int q4, @RequestParam("q5") int q5) {
		logger.info("leveltest Result");
		
		MemberVo mvo = (MemberVo)session.getAttribute("login");
		String memberId = mvo.getMemberId();
		vo.setMemberId(memberId);
		
		int levelScore = q1+ q2 + q3 + q4 + q5;
		
		vo.setLevelScore(levelScore);
		if(levelScore >= 80) {
			vo.setMemberLevel("상");
		}else if(levelScore < 80 && levelScore >= 60 ) {
			vo.setMemberLevel("중");
		}else {
			vo.setMemberLevel("하");
		}
		
		int res = service.insert(vo); 
		
		if (res > 0) {
			logger.info("[leveltest]insert success");
		} else {
			logger.info("[leveltest]insert fail....");
		}
		
		ModelAndView mav = new ModelAndView("leveltest/leveltestResult");

		
		mav.addObject("lvo", service.selectLevel(memberId));
		mav.addObject("list", service.selectList(vo.getMemberLevel()));

		return mav; 
	}

}
