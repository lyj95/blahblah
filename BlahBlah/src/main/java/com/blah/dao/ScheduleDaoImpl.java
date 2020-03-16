package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.CalendarVo;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CalendarVo> selectCalendar(String memberId) {
		
		List<CalendarVo> res = new ArrayList<CalendarVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectCalendar", memberId);	
		}catch(Exception e) {
			System.out.println("[error] : schedule selectCalendar");
			e.printStackTrace();
		}
		return res;
	}

}
