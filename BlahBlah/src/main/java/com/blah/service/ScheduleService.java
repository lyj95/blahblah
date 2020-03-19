package com.blah.service;

import java.util.Date;
import java.util.List;

import com.blah.vo.CalendarVo;
import com.blah.vo.MemberVo;

public interface ScheduleService {
	
	public List<CalendarVo> selectCalendar(MemberVo vo);
	
	@Deprecated
	public List<CalendarVo> selectTutorCalendar(String tutorId);

	public String updateDateByUser(CalendarVo calendar, int classCnt, Date updateDate);

	public String updateDateByTutor(CalendarVo calendar, int classCnt, Date updateDate);

	public String updateClassDate(CalendarVo calendar, int classCnt, Date updateDate);

}
