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

	public MemberVo checkApiId(String memberId);
	public int insertApiMember(MemberVo vo);
	public Map<String, String> selectEmail(String memberId);
	public int updatePwd(MemberVo vo);
	
	}
	




