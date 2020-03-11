package com.blah.dao;

import java.util.HashMap;
import java.util.List;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

public interface UserDao {
	String NAMESPACE = "mypage.";
	public List<LessonVo> selectMyClass(MemberVo vo);
	public List<LessonVo> selectClosedMyClass(MemberVo vo);
	public MemberVo selectMember(MemberVo vo);
	public List<MyclassVo> selectProgress(MemberVo vo);
	public int updateProfile(MemberVo vo);
	public int updatePassword(MemberVo vo);
	public int deleteMember(MemberVo vo);
	public LessonVo getLessonInfo1(int lessonNo);
	public MyclassVo getClassInfo(int lessonNo);
	public HashMap<String, Object> getLessonInfo(int lessonNo);
	public List<String> selectTutorPhoto(MemberVo vo);
	public List<LessonVo> selectFav(String memberId);
}
