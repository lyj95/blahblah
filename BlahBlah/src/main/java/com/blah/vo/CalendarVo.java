package com.blah.vo;

import java.util.Date;

public class CalendarVo {
	private String memberId;
	private int lessonNo;
	private String lessonName;
	private String lessonTime;
	private Date lessonStart;
	
	public CalendarVo() {
		super();
	}
		
	public CalendarVo(String memberId, int lessonNo, String lessonName, String lessonTime, Date lessonStart) {
		super();
		this.memberId = memberId;
		this.lessonNo = lessonNo;
		this.lessonName = lessonName;
		this.lessonTime = lessonTime;
		this.lessonStart = lessonStart;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getLessonNo() {
		return lessonNo;
	}

	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public Date getLessonStart() {
		return lessonStart;
	}

	public void setLessonStart(Date lessonStart) {
		this.lessonStart = lessonStart;
	}

	@Override
	public String toString() {
		return "CalendarVo [memberId=" + memberId + ", lessonNo=" + lessonNo + ", lessonName=" + lessonName
				+ ", lessonTime=" + lessonTime + ", lessonStart=" + lessonStart + "]";
	}
	
	
	
	
	
}
