package com.blah.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.LessonDao;
import com.blah.dao.ScheduleDao;
import com.blah.dao.UserDao;
import com.blah.vo.CalendarVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MsgVo;
import com.blah.vo.MyclassVo;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao dao;
	@Autowired
	private UserDao udao;
	@Autowired
	private LessonDao ldao;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		// 날짜 형식
	
	@Override
	public List<CalendarVo> selectCalendar(String memberId) {
		return dao.selectCalendar(memberId);
	}

	/**
	 * TUTOR가 강의 날짜를 변경
	 */
	@Override
	public String updateDateByTutor(CalendarVo calendar, int classCnt, Date updateDate) {
		// user가 가지고 있는 수업의 날짜 들고오기
		List<MyclassVo> schedule = dao.selectUserDates(calendar.getMemberId());
		String changeDate = format.format(updateDate);
		for(MyclassVo myClass : schedule) {
			Date[] compareDay = new Date[]{myClass.getLesson1st(), myClass.getLesson2nd(), myClass.getLesson3rd(),myClass.getLesson4th()};
			for(int i=0; i<compareDay.length; i++) {
				if(changeDate.compareTo(format.format(compareDay[i]))==0) {
					return "상대방이 해당 날짜에 스케줄이 있습니다. 다른 날짜를 선택해주세요.";
				}
			}
		}
		// TODO 위의 return 에 걸리지 않았다면 스케줄 변경이 가능하다는 소리 -> 날짜 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lessonNo", calendar.getLessonNo());
		map.put("memberId", calendar.getMemberId());
		map.put("whichClass", classCnt);
		map.put("updateDate", updateDate);
		int res = dao.updateDateByTutor(map);
		
		// 스케줄 바뀌면 알림 보내기
		if(res > 0) {
			LessonVo lesson = ldao.selectOne(calendar.getLessonNo());
			MsgVo msg = new MsgVo(calendar.getMemberId(),"["+lesson.getLessonName()+"]\n"+"위 강의의 스케줄이 변경되었습니다. \n자세한 사항은 마이페이지 스케줄에서 확인해주세요 !");
			udao.insertMsg(msg);
		}
		
		return (res>0)? "스케줄 변경에 성공했습니다.":"스케줄 변경에 실패했습니다.";
	}
	
	@Override
	public String updateDateByUser(CalendarVo calendar, int classCnt, Date updateDate) {
		//ArrayList<MyclassVo> schedule = dao.selectTutorDates();
		return null;
	}
	
	@Override
	public List<CalendarVo> selectTutorCalendar(String tutorId) {
		return dao.selectTutorCalendar(tutorId);
	}

}
