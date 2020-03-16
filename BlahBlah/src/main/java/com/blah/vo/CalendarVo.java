package com.blah.vo;


public class CalendarVo {
	private String memberId;
	private int lessonNo;
	private String lessonName;
	private String lessonTime;
	private String tutorId;
	private String myclassDate1;
	private String myclassDate2;
	private String myclassDate3;
	private String myclassDate4;
	
	public CalendarVo() {
		super();
	}

	public CalendarVo(String memberId, int lessonNo, String lessonName, String lessonTime, String tutorId, String myclassDate1, String myclassDate2, String myclassDate3, String myclassDate4) {
		super();
		this.memberId = memberId;
		this.lessonNo = lessonNo;
		this.lessonName = lessonName;
		this.lessonTime = lessonTime;
		this.tutorId = tutorId;
		this.myclassDate1 = myclassDate1;
		this.myclassDate2 = myclassDate2;
		this.myclassDate3 = myclassDate3;
		this.myclassDate4 = myclassDate4;
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

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

//	public String getPaymentDay() {
//		return paymentDay;
//	}
//
//	public void setPaymentDay(String paymentDay) {
//		this.paymentDay = paymentDay;
//	}

	public String getMyclassDate1() {
		return myclassDate1;
	}

	public void setMyclassDate1(String myclassDate1) {
		this.myclassDate1 = myclassDate1;
	}

	public String getMyclassDate2() {
		return myclassDate2;
	}

	public void setMyclassDay2(String myclassDate2) {
		this.myclassDate2 = myclassDate2;
	}

	public String getMyclassDate3() {
		return myclassDate3;
	}

	public void setMyclassDate3(String myclassDate3) {
		this.myclassDate3 = myclassDate3;
	}

	public String getMyclassDate4() {
		return myclassDate4;
	}

	public void setMyclassDate4(String myclassDate4) {
		this.myclassDate4 = myclassDate4;
	}

	
	@Override
	public String toString() {
		return "CalendarVo [memberId=" + memberId + ", lessonNo=" + lessonNo + ", lessonName=" + lessonName
				+ ", lessonTime=" + lessonTime + ", tutorId=" + tutorId 
				+ ", myclassDate1=" + myclassDate1 + ", myclassDate2=" + myclassDate2 + ", myclassDate3=" + myclassDate3
				+ ", myclassDate4=" + myclassDate4 + "]";
	}
	
	
	
	
	
			
}
