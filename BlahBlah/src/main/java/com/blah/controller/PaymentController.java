package com.blah.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LessonService;
import com.blah.service.PaymentService;

@Controller
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private LessonService ls;
	@Autowired
	private PaymentService ps;
	
	String userId = "user01";
	
	@RequestMapping(value = "/chkTable", method=RequestMethod.POST)
	@ResponseBody									
	public Map<String, Boolean> checkingTable(@RequestBody Map<String, String> jdata) {
		
		logger.info("[payment] checking payment Table");
		
		String lessonNo = jdata.get("lessonNo");	//넘어온 json data : lessonNo
		
		HashMap<String, Object> lessonNoMap = new HashMap<String, Object>();
		lessonNoMap.put("lessonNo", lessonNo);
		lessonNoMap.put("userId", userId);

		boolean	res = false;	//결과값 초기화
		
		//결제테이블에 userId, lessonNo 등록되어있는지 확인(둘다 없어야 가능)
		boolean checkPay = ps.checkPay(lessonNoMap);
		
		if(checkPay == true) {
			res=false;	//테이블에 존재O, 결제 진행X
		} else {
			res=true;	//테이블에 존재X, 결제 진행O
		}
			
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("res", res);
		
		return map;	
	}
	
	@RequestMapping(value = "/payment")
	public String payLesson(Model model, int lessonNo) {
		logger.info("[payment] into the payment");
		logger.info("lessonNo : "+lessonNo);
		int lessonPrice = ls.selectOne(lessonNo).getLessonPrice();		//lessonNo로 결제금액 가져오기
		//String userId = (String) session.getAttribute("login");			//session의 ID
		//String userName = us.selectOne(userId).getMemberName();		//ID로 회원이름 가져오기
		//String userEmail = us.selectOne(userId).getMemberEmail();		//ID로 회원메일 가져오기
		
		model.addAttribute("lessonNo", lessonNo);
		model.addAttribute("userId", userId);	
		model.addAttribute("lessonPrice", lessonPrice);	
		//model.addAttribute("userName", userName);	
		//model.addAttribute("userEmail", userEmail);	
		
		return "payment/payment";
	}
	
	@RequestMapping(value = "/blahpay", method=RequestMethod.POST)
	@ResponseBody									
	public Map<String, Boolean> payResult(HttpSession session, @RequestBody Map<String, String> jdata) {
		
		logger.info("[payment] checking payment info");
		
		//넘어온 json data : impUid, paidAmount, lessonNo, userid
		System.out.println("impUid : "+jdata.get("impUid"));
		System.out.println("paidAmount : "+jdata.get("paidAmount"));	//lessonNo로 테이블에서 가져온 값과 비교
		System.out.println("lessonNo : "+jdata.get("lessonNo"));
		System.out.println("userId : "+jdata.get("userId"));			//session의 id 가져와서 비교
		
		String impUid = jdata.get("impUid");
		String lessonNo = jdata.get("lessonNo");
		String userId = jdata.get("userId");
		
		HashMap<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put("userId", userId);
		selectMap.put("lessonNo", lessonNo);
		System.out.println("selectMap : "+selectMap);

		HashMap<String, Object> insertMap = new HashMap<String, Object>();
		insertMap.put("userId", userId);
		insertMap.put("lessonNo", lessonNo);
		insertMap.put("impUid", impUid);
		System.out.println("insertMap : "+insertMap);
		
		boolean	everythings_fine = false;
		boolean checkPay = ps.checkPay(selectMap);
		System.out.println("checkPay : "+checkPay);
		//결제테이블에 userId, lessonNo 등록되어있는지(둘다 없어야 가능)
		if(checkPay == true) {
			everythings_fine=false;
		} else {
			System.out.println("null일 경우 insert 진입");
			if((ps.insert(insertMap)) > 0) {
				session.setAttribute("userId", userId);	//session에 로그인 정보를 담아주어야 로그인이 유지됨
				everythings_fine=true;
			}
			
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("everythings_fine", everythings_fine);
		
		return map;	
	}
}
