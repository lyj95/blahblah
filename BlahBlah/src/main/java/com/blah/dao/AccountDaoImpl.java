package com.blah.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.MemberVo;


@Repository
public class AccountDaoImpl implements AccountDao {
	@Override
	public String checkId(String memberId) throws Exception{
		
		return sqlSession.selectOne("idchk.idchk", memberId);
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo res = null;
		System.out.println(vo.getMemberId());
		System.out.println(vo.getMemberPw());
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login",vo);
		}catch (Exception e) {
			System.out.println("[error] : LOGIN");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insert(MemberVo vo) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insert",vo);
		}catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}

	



}











