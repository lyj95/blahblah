package com.blah.dao;

import java.util.HashMap;

import com.blah.vo.LessonVo;

public interface PaymentDao {
	String namespace ="payment.";
	boolean checkPay(HashMap<String, Object> selectMap);		//결제 전 payment 테이블 확인
	int insert(HashMap<String, Object> insertMap);				//payment 테이블 insert
	String selectDay(String lessonNo);							//강의요일 select
	int chkLessonEnd(int lessonNo);								//수업신청마감 확인
	int chkMyLesson(int lessonNo, String memberId);				//해당 강의가 본인이 신청한 강의인지 확인
	
}
