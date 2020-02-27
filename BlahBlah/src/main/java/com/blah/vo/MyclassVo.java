package com.blah.vo;

import java.util.Date;

public class MyclassVo {
	private int lessonNo;
	private String memberId;
	private int myclassTotalcnt; 	//수강 총횟수
	private int myclassRemaincnt; 	//수강 남은횟수
	private Date paymentDay;
	private String impUid;
	private Date lesson1st;
	private Date lesson2nd;
	private Date lesson3rd;
	private Date lesson4th;
	
	
	public MyclassVo() {
		super();
	}
	
	public MyclassVo(int lessonNo, String memberId, int myclassTotalcnt, int myclassRemaincnt, Date paymentDay,
			String impUid, Date lesson1st, Date lesson2nd, Date lesson3rd, Date lesson4th) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
		this.myclassTotalcnt = myclassTotalcnt;
		this.myclassRemaincnt = myclassRemaincnt;
		this.paymentDay = paymentDay;
		this.impUid = impUid;
		this.lesson1st = lesson1st;
		this.lesson2nd = lesson2nd;
		this.lesson3rd = lesson3rd;
		this.lesson4th = lesson4th;
	}

	public int getLessonNo() {
		return lessonNo;
	}
	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMyclassTotalcnt() {
		return myclassTotalcnt;
	}
	public void setMyclassTotalcnt(int myclassTotalcnt) {
		this.myclassTotalcnt = myclassTotalcnt;
	}
	public int getMyclassRemaincnt() {
		return myclassRemaincnt;
	}
	public void setMyclassRemaincnt(int myclassRemaincnt) {
		this.myclassRemaincnt = myclassRemaincnt;
	}
	public Date getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(Date paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getImpUid() {
		return impUid;
	}
	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public Date getLesson1st() {
		return lesson1st;
	}

	public void setLesson1st(Date lesson1st) {
		this.lesson1st = lesson1st;
	}

	public Date getLesson2nd() {
		return lesson2nd;
	}

	public void setLesson2nd(Date lesson2nd) {
		this.lesson2nd = lesson2nd;
	}

	public Date getLesson3rd() {
		return lesson3rd;
	}

	public void setLesson3rd(Date lesson3rd) {
		this.lesson3rd = lesson3rd;
	}

	public Date getLesson4th() {
		return lesson4th;
	}

	public void setLesson4th(Date lesson4th) {
		this.lesson4th = lesson4th;
	}

	@Override
	public String toString() {
		return "MyclassVo [lessonNo=" + lessonNo + ", memberId=" + memberId + ", myclassTotalcnt=" + myclassTotalcnt
				+ ", myclassRemaincnt=" + myclassRemaincnt + ", paymentDay=" + paymentDay + ", impUid=" + impUid
				+ ", lesson1st=" + lesson1st + ", lesson2nd=" + lesson2nd + ", lesson3rd=" + lesson3rd + ", lesson4th="
				+ lesson4th + "]";
	}
	
	
	
	
}
