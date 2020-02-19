package com.blah.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.PaymentVo;

@Repository
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean checkPay(HashMap<String, Object> selectMap) {
		boolean checkPay = true;
		try {
			PaymentVo paymentVo = sqlSession.selectOne(namespace+"selectOne", selectMap);
			System.out.println("paymentVo : "+paymentVo);
			
			if(paymentVo != null) {
				checkPay = true;	//테이블에 존재O, 결제 진행X
			} else {
				checkPay = false;	//테이블에 존재X, 결제 진행O
			}
		}catch(Exception e) {
			System.out.println("[error] : checking Payment Table");
			e.printStackTrace();
		}	
		
		return checkPay;
	}

	@Override
	public int insert(HashMap<String, Object> insertMap) {
		int res=0;
		try {
			res= sqlSession.insert(namespace+"insert", insertMap);
		}catch(Exception e) {
			System.out.println("[error] : payment table insert ");
			e.printStackTrace();
		}
		return res;
	}

}
