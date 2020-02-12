package com.blah.vo;

import java.util.Date;

public class CalendarVo {
	private Date calendarDate;
	private String memberId;
	private String calendarContent;
	
	public CalendarVo() {
		super();
	}

	public CalendarVo(Date calendarDate, String memberId, String calendarContent) {
		super();
		this.calendarDate = calendarDate;
		this.memberId = memberId;
		this.calendarContent = calendarContent;
	}

	public Date getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCalendarContent() {
		return calendarContent;
	}

	public void setCalendarContent(String calendarContent) {
		this.calendarContent = calendarContent;
	}

	@Override
	public String toString() {
		return "CalendarVo [calendarDate=" + calendarDate + ", memberId=" + memberId + ", calendarContent="
				+ calendarContent + "]";
	}
	
	
	
}
