package com.blah.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDao dao;
	
	@Override
	public boolean checkPay(HashMap<String, Object> selectMap) {
		// TODO Auto-generated method stub
		return dao.checkPay(selectMap);
	}

	@Override
	public int insert(HashMap<String, Object> insertMap) {
		// TODO Auto-generated method stub
		return dao.insert(insertMap);
	}

	@Override
	public String selectDay(String lessonNo) {
		// TODO Auto-generated method stub
		return dao.selectDay(lessonNo);
	}

}
