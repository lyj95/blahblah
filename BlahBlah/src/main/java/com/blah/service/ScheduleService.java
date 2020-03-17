package com.blah.service;

import java.util.List;

import com.blah.vo.CalendarVo;

public interface ScheduleService {
	
	public List<CalendarVo> selectCalendar(String memberId);
	public List<CalendarVo> selectTutorCalendar(String tutorId);

}
