package com.blah.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


import com.blah.vo.MemberVo;

public interface AccountService {

	public MemberVo login(MemberVo vo);

	public int signup(MemberVo vo);

	public String idchk(String memberId) throws Exception;
	
	Map<String,String>selectSearchId(Map<String,String> map);

	Map<String,String>selectSearchPw(Map<String,String> map);
	
}
