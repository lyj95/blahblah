package com.blah.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.MemberVo;


@Repository
public class AccountDaoImpl implements AccountDao {
	@Override
	public String checkId(String memberId) throws Exception{
		
		return sqlSession.selectOne("member2.idchk", memberId);
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login",vo);
		}catch (Exception e) {
			System.out.println("[error] : LOGIN");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int signup(MemberVo vo) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE2+"sign",vo);
		}catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public Map<String, String> selectSearchId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE2+"findId",map);
		}

	@Override
	public Map<String, String> selectSearchPw(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE2+"findPw",map);
	}


	
	



}











