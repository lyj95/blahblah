package com.blah.vo;

import java.util.Date;

public class MyclassVo {
	private int lessonNo;
	private String memberId;
	private int myclassTotalcnt; 	//수강 총횟수
	private int myclassRemaincnt; 	//수강 남은횟수
	private Date paymentDay;
	private String impUid;
	
	public MyclassVo() {
		super();
	}
	public MyclassVo(int lessonNo, String memberId, int myclassTotalcnt, int myclassRemaincnt, Date paymentDay,
			String impUid) {
		super();
		this.lessonNo = lessonNo;
		this.memberId = memberId;
		this.myclassTotalcnt = myclassTotalcnt;
		this.myclassRemaincnt = myclassRemaincnt;
		this.paymentDay = paymentDay;
		this.impUid = impUid;
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
	@Override
	public String toString() {
		return "MyclassVo [lessonNo=" + lessonNo + ", memberId=" + memberId + ", myclassTotalcnt=" + myclassTotalcnt
				+ ", myclassRemaincnt=" + myclassRemaincnt + ", paymentDay=" + paymentDay + ", impUid=" + impUid + "]";
	}
	
	
}
