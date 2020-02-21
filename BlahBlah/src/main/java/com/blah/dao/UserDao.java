package com.blah.dao;

import java.util.List;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

public interface UserDao {
	String NAMESPACE = "mypage.";
	public List<LessonVo> selectMyClass(String memberId);
	public List<LessonVo> selectClosedMyClass(String memberId);
	public MemberVo selectMember(String memberId);
	public List<MyclassVo> selectProgress(String memberId);
	public int updateProfile(MemberVo vo);
	public int updatePassword(MemberVo vo);
	public int deleteMember(MemberVo vo);
}
