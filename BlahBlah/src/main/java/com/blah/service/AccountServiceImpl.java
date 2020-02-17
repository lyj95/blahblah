package com.blah.service;

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
	public int insert(MemberVo vo) {
		return dao.insert(vo);
	}

	@Override
	public String idchk(String memberId) throws Exception {
		
		return dao.checkId(memberId);
	}
	
}


