package com.blah.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.MyclassVo;

@Repository
public class PaymentDaoImpl implements PaymentDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean checkPay(HashMap<String, Object> selectMap) {
		boolean checkPay = true;
		try {
			System.out.println("dao 넘겨줄  selectMap : "+selectMap);
			System.out.println("namespac : "+namespace);
			
			MyclassVo myclassVo = sqlSession.selectOne(namespace+"selectOne", selectMap);
			System.out.println("dao myclassVo : "+myclassVo);
			
			if(myclassVo != null) {
				checkPay = true;	//테이블에 존재O, 결제 진행X
			} else {
				checkPay = false;	//테이블에 존재X, 결제 진행O
			}
		}catch(Exception e) {
			System.out.println("[error] : checking Myclass Table");
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
			System.out.println("[error] : Myclass table insert ");
			e.printStackTrace();
		}
		return res;
	}

}
