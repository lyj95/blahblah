package com.blah.dao;

import java.util.Map;

import com.blah.vo.MemberVo;

public interface AccountDao {
	String NAMESPACE = "member.";
	String NAMESPACE2 = "member2.";
	
	public MemberVo login(MemberVo vo);
	public int signup(MemberVo vo);
	public String checkId(String memberId) throws Exception;

	
	Map<String,String> selectSearchId(Map<String,String> map);
	Map<String,String> selectSearchPw(Map<String,String> map);
	
	
	}
	




