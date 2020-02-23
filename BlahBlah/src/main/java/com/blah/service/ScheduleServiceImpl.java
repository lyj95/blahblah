package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.ScheduleDao;
import com.blah.vo.CalendarVo;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao dao;

	@Override
	public List<CalendarVo> selectCalendar(String memberId) {
		return dao.selectCalendar(memberId);
	}

}
