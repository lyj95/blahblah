package com.blah.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;
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
			System.out.println("namespace : "+namespace);
			
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

	@Override
	public String selectDay(String lessonNo) {
		String classday = "";
		try {
		classday = sqlSession.selectOne(namespace+"selectDay", lessonNo);
		}catch(Exception e) {
			System.out.println("[error] : Myclass select classDay ");
			e.printStackTrace();
		}
		return classday;
	}

	@Override
	public int chkLessonEnd(int lessonNo) {
		int endLesson = sqlSession.selectOne(namespace+"chkLessonEnd", lessonNo);
			  System.out.println("endLesson : "+endLesson);
			  if(endLesson > 0) {
				  return endLesson;
				} else {
				  return 0;
				}
		  
	}

	@Override
	public int chkMyLesson(int lessonNo, String memberId) {
		
		System.out.println("daoimpl : "+lessonNo+" / "+memberId);
		Map<String, Object> map = new HashMap<>();
		map.put("lessonNo", lessonNo);
		map.put("memberId", memberId);
		System.out.println("daoimpl map : "+map);
		
		int myLesson = 0;
		
			myLesson = sqlSession.selectOne(namespace+"isMyLesson", map);
			System.out.println("daoimpl myLesson : "+myLesson);
			  if(myLesson > 0) {
				  return myLesson;
				} else {
				  return 0;
				}
		 
	}

}
