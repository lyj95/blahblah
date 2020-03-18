package com.blah.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blah.vo.FeedbackVo;
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
	public int insertFeedback(FeedbackVo vo);
	public String getTutorName(int lessonNo);
	public List<FeedbackVo> selectFeedback(Map<String, Object> pk);
	public int updateFeedback(FeedbackVo vo);
	public List<LessonVo> selectFav(String memberId);
	public int setRemainClass(Map<String, Object> pk);
	public int wroteFeedback(Map<String, Object> pk);
	public HashMap<String, Integer> getProgress(Map<String, String> map);
	public String getUserType(String userId);
}
