package com.blah.dao;

import java.util.List;
import java.util.Map;

import com.blah.vo.CalendarVo;
import com.blah.vo.MyclassVo;

public interface ScheduleDao {
	
	String NAMESPACE = "calendar.";

	public List<CalendarVo> selectCalendar(String memberId);

	public List<MyclassVo> selectUserDates(String memberId);
	public List<MyclassVo> selectTutorDates(CalendarVo calendar);

	public int updateDateByTutor(Map<String, Object> map);
	public List<CalendarVo> selectTutorCalendar(String tutorId);

	
}
