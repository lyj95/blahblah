package com.blah.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.blah.dao.AccountDao;

import com.blah.vo.MemberVo;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao dao;
	
	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}

	@Override
	public int signup(MemberVo vo) {
		return dao.signup(vo);
	}
	@Override
	public String idchk(String memberId) throws Exception {
		
		return dao.checkId(memberId);
	}
	public Map<String, String> selectSearchId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectSearchId(map);
	}

	public Map<String, String> selectSearchPw(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectSearchPw(map);
	}
	
}


