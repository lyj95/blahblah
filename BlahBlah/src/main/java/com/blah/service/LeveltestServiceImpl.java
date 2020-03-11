package com.blah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.LeveltestDao;
import com.blah.vo.LeveltestVo;

@Service
public class LeveltestServiceImpl implements LeveltestService{
	
	@Autowired
	private LeveltestDao dao;

	@Override
	public int insert(LeveltestVo vo) {
		return dao.insert(vo);
	}

	@Override
	public LeveltestVo selectLevel(String memberId) {
		System.out.println("into service");
		return dao.selectLevel(memberId);
	}



}
