package com.blah.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;

import com.blah.vo.FilesVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

public interface UserService {
	public List<LessonVo> selectMyClass(String memberId);
	public List<LessonVo> selectClosedMyClass(String memberId);
	public MemberVo selectMember(String memberId);
	public List<MyclassVo> selectProgress(String memberId);
	public void uploadProfile(HttpServletRequest request, HttpSession session, FilesVo uploadFile, MemberVo vo);
	public Map<String, Boolean> changePw(MemberVo vo, HashMap<String, String> hmap);
	public Map<String, Boolean> deleteMember(MemberVo vo, String nowpw);
}
