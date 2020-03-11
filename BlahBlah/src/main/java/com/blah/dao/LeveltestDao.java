package com.blah.dao;

import com.blah.vo.LeveltestVo;

public interface LeveltestDao {

	String NAMESPACE = "leveltest.";

	public int insert(LeveltestVo vo);
	public LeveltestVo selectLevel(String memberId);
	
	
}
