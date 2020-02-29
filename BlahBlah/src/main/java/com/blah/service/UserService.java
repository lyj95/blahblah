package com.blah.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.blah.vo.FilesVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

public interface UserService {
	public List<LessonVo> selectMyClass(MemberVo vo);
	public List<LessonVo> selectClosedMyClass(MemberVo vo);
	public MemberVo selectMember(MemberVo vo);
	public List<MyclassVo> selectProgress(MemberVo vo);
	public void uploadProfile(HttpServletRequest request, HttpSession session, FilesVo uploadFile, MemberVo vo);
	public Map<String, Boolean> changePw(MemberVo vo, HashMap<String, String> hmap);
	public HashMap<String, Object> getLessonInfo(int lessonNo, String userId);
	public String deleteMember(MemberVo vo, String nowpw);
	public List<String> selectTutorPhoto(MemberVo vo);
}
