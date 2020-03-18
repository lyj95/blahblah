package com.blah.service;

import java.util.Date;
import java.util.List;

import com.blah.vo.CalendarVo;

public interface ScheduleService {
	
	public List<CalendarVo> selectCalendar(String memberId);

	public String updateDateByUser(CalendarVo calendar, int classCnt, Date updateDate);

	public String updateDateByTutor(CalendarVo calendar, int classCnt, Date updateDate);

}
