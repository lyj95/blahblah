package com.blah.service;

import java.util.HashMap;

public interface PaymentService {
	boolean checkPay(HashMap<String, Object> selectMap);	//결제 전 payment 테이블 확인
	int insert(HashMap<String, Object> insertMap);			//payment 테이블 insert
	String selectDay(String lessonNo);						//강의요일 select
}
