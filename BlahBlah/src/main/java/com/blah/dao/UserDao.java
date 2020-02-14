package com.blah.dao;

import java.util.List;

import com.blah.vo.LessonVo;

public interface UserDao {
	String NAMESPACE = "mypage.";
	public List<LessonVo> selectMyClass(String memberId);
	public List<LessonVo> selectClosedMyClass(String memberId);
}
