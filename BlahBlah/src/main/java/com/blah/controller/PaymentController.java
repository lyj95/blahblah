package com.blah.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.blah.service.LessonService;
import com.blah.service.PaymentService;
import com.blah.service.UserService;
import com.blah.vo.MemberVo;

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
		String memberId = (String) session.getAttribute("MemberId");	//session의 ID
		
		String lessonNo = jdata.get("lessonNo");	//넘어온 json data : lessonNo
		System.out.println("ctrl lessonNo : "+lessonNo);
		HashMap<String, Object> lessonNoMap = new HashMap<String, Object>();
		lessonNoMap.put("lessonNo", lessonNo);
		lessonNoMap.put("memberId", memberId);
		System.out.println("ctrl lessonNoMap : "+lessonNoMap);
		boolean	res = false;	//결과값 초기화
		
		//결제테이블에 userId, lessonNo 등록되어있는지 확인(둘다 없어야 가능)
		boolean checkPay = ps.checkPay(lessonNoMap);
		System.out.println("ctrl checkPay : "+checkPay);
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
		MemberVo vo = (MemberVo)session.getAttribute("login");				//세션
		
		logger.info("lessonNo : "+lessonNo);
		int lessonPrice = ls.selectOne(lessonNo).getLessonPrice();			//lessonNo로 결제금액 가져오기
		String memberId = us.selectMember(vo).getMemberId();
		String userName = us.selectMember(vo).getMemberName();		//ID로 회원이름 가져오기
		String userEmail = us.selectMember(vo).getMemberEmail();		//ID로 회원메일 가져오기
		
		model.addAttribute("lessonNo", lessonNo);
		model.addAttribute("lessonPrice", lessonPrice);	
		model.addAttribute("memberId", memberId);	
		model.addAttribute("userName", userName);	
		model.addAttribute("userEmail", userEmail);	
		
		System.out.println("*****************************************************************");
		
		//결제일(오늘) 요일 구하기
		String[] weekDay = { "일", "월", "화", "수", "목", "금", "토" };
		Calendar cal = Calendar.getInstance(); 
		int num = cal.get(Calendar.DAY_OF_WEEK)-1; 
		String today = weekDay[num]; 
		System.out.println(num); 
		System.out.println("오늘의 요일 : " + today ); 
		
		//일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7)
		int todayint = 0;
		//결제일(오늘)의 요일 번호 todayint
		switch(today) {
		case "일" : 
			todayint = 1; break;
		case "월" :
			todayint = 2; break;
		case "화" : 
			todayint = 3; break;
		case "수" : 
			todayint = 4; break;
		case "목" :
			todayint = 5; break;
		case "금" : 
			todayint = 6; break;
		case "토" : 
			todayint = 7; break;
		}
		
		//강의요일
		String classday = "화";	//lesson테이블에서 lesson_time 가져와서 제일앞 요일 가져오기(매주 무슨 요일 강의?)
		int classdayint = 0;
		//강의 요일 번호 classdayint
		switch(classday) {
		case "일" : 
			classdayint = 1; break;
		case "월" :
			classdayint = 2; break;
		case "화" : 
			classdayint = 3; break;
		case "수" : 
			classdayint = 4; break;
		case "목" :
			classdayint = 5; break;
		case "금" : 
			classdayint = 6; break;
		case "토" : 
			classdayint = 7; break;
		}
		
		if(todayint >= classdayint) {
			int minusday = 7 - (todayint - classdayint);
			
			//오늘날짜(결제) + (7 - (결제요일 - 강의요일)) = 첫 강의날짜
			cal.setTime(new Date()); 
			cal.add(Calendar.DATE, minusday);
			Date lesson1st = cal.getTime();
			System.out.println("강의 1회차 : "+lesson1st);
			cal.setTime(lesson1st); 
			cal.add(Calendar.DATE, 7);
			Date lesson2nd = cal.getTime();
			System.out.println("강의 2회차 : "+lesson2nd);
			cal.setTime(lesson2nd); 
			cal.add(Calendar.DATE, 7);
			Date lesson3rd = cal.getTime();
			System.out.println("강의 3회차 : "+lesson3rd);
			cal.setTime(lesson3rd); 
			cal.add(Calendar.DATE, 7);
			Date lesson4th = cal.getTime();
			System.out.println("강의 4회차 : "+lesson4th);
			
			model.addAttribute("lesson1st", lesson1st);	
			model.addAttribute("lesson2nd", lesson2nd);	
			model.addAttribute("lesson3rd", lesson3rd);	
			model.addAttribute("lesson4th", lesson4th);	
			
		} else {
			int minusday = 7 + (classdayint - todayint);
			
			//오늘날짜(결제) + (7 + (강의요일)-(결제요일) = 첫 강의날짜
			cal.setTime(new Date()); 
			cal.add(Calendar.DATE, minusday);
			Date lesson1st = cal.getTime();
			System.out.println("강의 1회차 : "+lesson1st);
			cal.setTime(lesson1st); 
			cal.add(Calendar.DATE, 7);
			Date lesson2nd = cal.getTime();
			System.out.println("강의 2회차 : "+lesson2nd);
			cal.setTime(lesson2nd); 
			cal.add(Calendar.DATE, 7);
			Date lesson3rd = cal.getTime();
			System.out.println("강의 3회차 : "+lesson3rd);
			cal.setTime(lesson3rd); 
			cal.add(Calendar.DATE, 7);
			Date lesson4th = cal.getTime();
			System.out.println("강의 4회차 : "+lesson4th);
			
			model.addAttribute("lesson1st", lesson1st);	
			model.addAttribute("lesson2nd", lesson2nd);	
			model.addAttribute("lesson3rd", lesson3rd);	
			model.addAttribute("lesson4th", lesson4th);	
		}
		
		System.out.println("*****************************************************************");
		
		
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
		System.out.println("memberId : "+jdata.get("memberId"));			//session의 id 가져와서 비교
		
		String impUid = jdata.get("impUid");
		String lessonNo = jdata.get("lessonNo");
		String memberId = jdata.get("memberId");
		String lesson1st = jdata.get("lesson1st");
		String lesson2nd = jdata.get("lesson2nd");
		String lesson3rd = jdata.get("lesson3rd");
		String lesson4th = jdata.get("lesson4th");
		
		
		HashMap<String, Object> selectMap = new HashMap<String, Object>();	//결제 테이블 재확인
		selectMap.put("memberId", memberId);
		selectMap.put("lessonNo", lessonNo);
		System.out.println("selectMap : "+selectMap);

		HashMap<String, Object> insertMap = new HashMap<String, Object>();	//결제 테이블에 insert
		insertMap.put("memberId", memberId);
		insertMap.put("lessonNo", lessonNo);
		insertMap.put("impUid", impUid);
		insertMap.put("lesson1st", lesson1st);
		insertMap.put("lesson2nd", lesson2nd);
		insertMap.put("lesson3rd", lesson3rd);
		insertMap.put("lesson4th", lesson4th);
		System.out.println("insertMap : "+insertMap);
		
		boolean	everythings_fine = false;
		boolean checkPay = ps.checkPay(selectMap);
		System.out.println("checkPay : "+checkPay);
		
		System.out.println("*****************************************************************");
		
		Date today = new Date();
		System.out.println("today : "+today);
		
		
		System.out.println("*****************************************************************");
		
		//결제테이블에 userId, lessonNo 등록되어있는지(둘다 없어야 가능)
		if(checkPay == true) {
			everythings_fine=false;
		} else {
			System.out.println("null일 경우 insert 진입");
			if((ps.insert(insertMap)) > 0) {
				session.setAttribute("memberId", memberId);	//session에 로그인 정보를 담아주어야 로그인이 유지됨
				everythings_fine=true;
			}
			
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("everythings_fine", everythings_fine);
		
		return map;	
	}
}
