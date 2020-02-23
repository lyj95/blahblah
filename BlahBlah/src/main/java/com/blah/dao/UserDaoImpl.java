package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

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

	@Override
	public List<MyclassVo> selectProgress(String memberId) {
		List<MyclassVo> list = new ArrayList<MyclassVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectProgress", memberId);
		} catch(Exception e) {
			System.out.println("[error] : selectProgress");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int updateProfile(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"updateProfile", vo);
		} catch(Exception e) {
			System.out.println("[error] : updateProfile");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updatePassword(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatePassword", vo);
		} catch(Exception e) {
			System.out.println("[error] : updatePassword");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteMember(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"deleteMember", vo);
		} catch(Exception e) {
			System.out.println("[error] : deleteMember");
			e.printStackTrace();
		}
		return res;
	}


}
