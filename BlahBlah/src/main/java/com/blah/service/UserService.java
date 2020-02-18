package com.blah.service;

import java.util.List;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

public interface UserService {
	public List<LessonVo> selectMyClass(String memberId);
	public List<LessonVo> selectClosedMyClass(String memberId);
	public MemberVo selectMember(String memberId);
	public List<MyclassVo> selectProgress(String memberId);
}
