package com.blah.service;

import java.util.List;

import com.blah.vo.LessonVo;
import com.blah.vo.LeveltestVo;


public interface LeveltestService {
	public int insert(LeveltestVo vo);
	public LeveltestVo selectLevel(String memberId);
	List<LessonVo> selectList(String memberLevel);
	public int selectCount(String memberId);

}
