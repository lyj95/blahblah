package com.blah.dao;

import com.blah.vo.MemberVo;

public interface AccountDao {
	String NAMESPACE = "member.";
	String NAMESPACE2 = "idchk.";
	
	public MemberVo login(MemberVo vo);
	public String checkId(String memberId) throws Exception;
	}
	




