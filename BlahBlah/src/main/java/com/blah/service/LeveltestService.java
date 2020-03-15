package com.blah.service;

import com.blah.vo.LeveltestVo;


public interface LeveltestService {
	public int insert(LeveltestVo vo);
	public LeveltestVo selectLevel(String memberId);

}
