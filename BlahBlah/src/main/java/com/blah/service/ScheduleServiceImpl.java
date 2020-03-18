package com.blah.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.ScheduleDao;
import com.blah.dao.UserDao;
import com.blah.dao.UserDaoImpl;
import com.blah.vo.CalendarVo;
import com.blah.vo.MyclassVo;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao dao;
	@Autowired
	private UserDao userDao = new UserDaoImpl();
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);		// 날짜 형식
	
	/**
	 * 유저 타입에 맞춘 calendar 스케줄 들고오기
	 */
	@Override
	public List<CalendarVo> selectCalendar(String memberId) {
		String type = userDao.getUserType(memberId);			// 유저 타입 확인
		List<CalendarVo> schedule; 
		System.out.println(type+" 타입");
		if(type.equals("USER")) {	// USER일 경우
			schedule = dao.selectCalendar(memberId);
		} else {		// TUTOR일 경우
			schedule = dao.selectTutorCalendar(memberId);	
		}
		return schedule;
	}

	/**
	 * TUTOR가 강의 날짜를 변경
	 */
	@Deprecated
	@Override
	public String updateDateByTutor(CalendarVo calendar, int classCnt, Date updateDate) {
		// user가 가지고 있는 수업의 날짜 들고오기
		List<MyclassVo> schedule = dao.selectUserDates(calendar.getMemberId());
		String changeDate = format.format(updateDate);
		for(MyclassVo myClass : schedule) {
			Date[] compareDay = new Date[]{myClass.getLesson1st(), myClass.getLesson2nd(), myClass.getLesson3rd(),myClass.getLesson4th()};
			for(int i=0; i<compareDay.length; i++) {
				System.out.println(compareDay[i]);
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
		return (res>0)? "스케줄 변경에 성공했습니다.":"스케줄 변경에 실패했습니다.";
	}
	@Deprecated
	@Override
	public String updateDateByUser(CalendarVo calendar, int classCnt, Date updateDate) {
		// 강의 Tutor가 가지고있는 수업의 날짜 들고와 비교하기
		List<MyclassVo> schedule = dao.selectTutorDates(calendar);
		System.out.println("리스트 개수 : "+schedule.size());
		String changeDate = format.format(updateDate);
		for(MyclassVo myClass : schedule) {
			Date[] compareDay = new Date[]{myClass.getLesson1st(), myClass.getLesson2nd(), myClass.getLesson3rd(),myClass.getLesson4th()};
			for(int i=0; i<compareDay.length; i++) {
				System.out.println("비교");
				System.out.println(format.format(compareDay[i])+" ==?? "+changeDate);
				if(changeDate.compareTo(format.format(compareDay[i]))==0) {
					System.out.println("같은 날짜가 존재한다!!!!ㄴ "+changeDate);
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
		return (res>0)? "스케줄 변경에 성공했습니다.":"스케줄 변경에 실패했습니다.";
	}
	
	@Override
	public String updateClassDate(CalendarVo calendar, int classCnt, Date updateDate) {
		List<MyclassVo> schedule;
		if(calendar.getTutorId() != null) {		// type : TUTOR
			schedule = dao.selectUserDates(calendar.getMemberId());
		}else {			// type : USER
			schedule = dao.selectTutorDates(calendar);
		}
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
		return (res>0)? "스케줄 변경에 성공했습니다.":"스케줄 변경에 실패했습니다.";
	}
	
	
	/**
	 * @deprecated
	 */
	@Override
	public List<CalendarVo> selectTutorCalendar(String tutorId) {
		return dao.selectTutorCalendar(tutorId);
	}

}
