package com.blah.service;

import java.util.Map;


import com.blah.vo.MemberVo;

public interface AccountService {

	public MemberVo login(MemberVo vo);

	public int signup(MemberVo vo);

	public String idchk(String memberId) throws Exception;
	
	Map<String,String>selectSearchId(Map<String,String> map);

	Map<String,String>selectSearchPw(Map<String,String> map);

	
}
