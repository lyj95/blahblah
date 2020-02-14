package com.blah.service;

import java.util.List;

import com.blah.vo.LessonVo;

public interface UserService {
	public List<LessonVo> selectMyClass(String memberId);
	public List<LessonVo> selectClosedMyClass(String memberId);
}
