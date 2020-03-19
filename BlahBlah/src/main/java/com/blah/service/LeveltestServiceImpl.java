package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.LeveltestDao;
import com.blah.vo.LessonVo;
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

	@Override
	public List<LessonVo> selectList(String memberLevel) {		
		return dao.selectList(memberLevel);
	}

	@Override
	public int selectCount(String memberId) {
		return dao.selectCount(memberId);
	}




}
