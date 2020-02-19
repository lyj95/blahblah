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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LessonService;
import com.blah.service.PaymentService;
import com.blah.service.UserService;

@Controller
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private LessonService ls;
	@Autowired
	private PaymentService ps;
	@Autowired
	private UserService us;
	
	
	/**
	 * 결제 진행 전 payment 테이블에 해당 강의가 결제된 내역이 있는지 확인 후 ajax로 결과 리턴
	 * @param HttpServletRequest request
	 * @param Map<String, String> jdata
	 * @return Map<String, Boolean> map
	 * @author star
	 */
	@RequestMapping(value = "/chkTable", method=RequestMethod.POST)
	@ResponseBody									
	public Map<String, Boolean> checkingTable(HttpServletRequest request, @RequestBody Map<String, String> jdata) {
		
		logger.info("[payment] checking payment Table");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");	//session의 ID
		
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
	
	
	
	/**
	 * 결제 페이지로 이동
	 * @param HttpServletRequest request
	 * @param Model model
	 * @param int lessonNo
	 * @return ViewName
	 * @author star
	 */
	@RequestMapping(value = "/payment")
	public String payLesson(HttpServletRequest request, Model model, int lessonNo) {
		logger.info("[payment] into the payment");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");	//session의 ID
		
		logger.info("lessonNo : "+lessonNo);
		int lessonPrice = ls.selectOne(lessonNo).getLessonPrice();		//lessonNo로 결제금액 가져오기
		String userName = us.selectMember(userId).getMemberName();		//ID로 회원이름 가져오기
		String userEmail = us.selectMember(userId).getMemberEmail();		//ID로 회원메일 가져오기
		
		model.addAttribute("lessonNo", lessonNo);
		model.addAttribute("lessonPrice", lessonPrice);	
		model.addAttribute("userId", userId);	
		model.addAttribute("userName", userName);	
		model.addAttribute("userEmail", userEmail);	
		
		return "payment/payment";
	}
	
	/**
	 * 결제 진행 
	 * @param HttpSession session
	 * @param Map<String, String> jdata
	 * @return Map<String, Boolean> map
	 * @author star
	 */
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
		
		HashMap<String, Object> selectMap = new HashMap<String, Object>();	//결제 테이블 재확인
		selectMap.put("userId", userId);
		selectMap.put("lessonNo", lessonNo);
		System.out.println("selectMap : "+selectMap);

		HashMap<String, Object> insertMap = new HashMap<String, Object>();	//결제 테이블에 insert
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
