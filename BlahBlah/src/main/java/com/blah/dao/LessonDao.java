package com.blah.dao;

import java.util.List;

import com.blah.vo.LessonVo;

public interface LessonDao {
	String namespace ="lesson.";
	List<LessonVo> selectlist();
	LessonVo selectOne(int lessonNo);
	int insert(LessonVo vo);
	public int update(LessonVo vo);
	public int delete(int lessonNo);

}
