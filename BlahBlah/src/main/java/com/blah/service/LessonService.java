package com.blah.service;

import java.util.List;

import com.blah.vo.LessonVo;

public interface LessonService {
	List<LessonVo> selectList();
	LessonVo selectOne(int lessonNo);
	int insert(LessonVo vo);
	public int update(LessonVo vo);
	public int delete(int lessonNo);
	

}
