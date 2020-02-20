package com.blah.dao;

import java.util.HashMap;

public interface PaymentDao {
	String namespace ="payment.";
	boolean checkPay(HashMap<String, Object> selectMap);		//결제 전 payment 테이블 확인
	int insert(HashMap<String, Object> insertMap);				//payment 테이블 insert
}
