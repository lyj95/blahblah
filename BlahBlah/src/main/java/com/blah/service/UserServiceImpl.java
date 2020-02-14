package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.UserDao;
import com.blah.vo.LessonVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public List<LessonVo> selectMyClass(String memberId) {
		return dao.selectMyClass(memberId);
	}

	@Override
	public List<LessonVo> selectClosedMyClass(String memberId) {
		return dao.selectClosedMyClass(memberId);
	}
}
