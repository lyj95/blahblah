package com.blah.service;

import com.blah.vo.MemberVo;

public interface AccountService {

	public MemberVo login(MemberVo vo);

	public int insert(MemberVo vo);

	public String idchk(String memberId) throws Exception;
}
