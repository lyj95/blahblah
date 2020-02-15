package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<LessonVo> selectMyClass(String memberId) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectMyClass", memberId);
		} catch(Exception e) {
			System.out.println("[error] : selectMyClass");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<LessonVo> selectClosedMyClass(String memberId) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectMyClosedClass", memberId);
		} catch(Exception e) {
			System.out.println("[error] : selectMyClosedClass");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVo selectMember(String memberId) {
		
		MemberVo vo = new MemberVo();
		
		try {
			vo = sqlSession.selectOne(NAMESPACE + "selectMember", memberId);
		} catch(Exception e) {
			System.out.println("[error] : selectMember");
			e.printStackTrace();
		}
		
		return vo;
	}
}
