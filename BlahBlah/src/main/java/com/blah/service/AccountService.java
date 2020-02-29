package com.blah.service;

import java.util.Map;
import java.util.HashMap;

import com.blah.vo.MemberVo;

public interface AccountService {

	public MemberVo login(MemberVo vo);

	public int signup(MemberVo vo);

	public String idchk(String memberId) throws Exception;
	
	Map<String,String>selectSearchId(Map<String,String> map);

	public MemberVo naverLogin(String apiResult);
	
	public MemberVo kakaoLogin(HashMap<String, String> userInfo);

	public Map<String, String> selectEmail(String memberId);

	public String newPwd();

	public int updatePwd(MemberVo vo);

	
}
