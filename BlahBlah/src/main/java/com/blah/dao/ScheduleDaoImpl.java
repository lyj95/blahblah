package com.blah.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.CalendarVo;
import com.blah.vo.MyclassVo;

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
	
	@Override
	public List<MyclassVo> selectUserDates(String memberId) {
		List<MyclassVo> schedule = sqlSession.selectList(NAMESPACE+"selectUserDates", memberId); 
		return schedule;
	}

	@Override
	public int updateDateByTutor(Map<String, Object> map) {
		int res = sqlSession.update(NAMESPACE+"updateDateByTutor", map);
		return res;
	}
}
