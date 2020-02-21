package com.blah.dao;

import java.util.List;

import com.blah.vo.CalendarVo;

public interface ScheduleDao {
	
	String NAMESPACE = "calendar.";

	public List<CalendarVo> selectCalendar(String memberId);
	
}
