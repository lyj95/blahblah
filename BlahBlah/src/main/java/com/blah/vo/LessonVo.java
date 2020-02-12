package com.blah.vo;

public class LessonVo {
	private String lessonNo;
	private String lessonName;
	private String lessonInfo;
	private String lessonLevel;
	private String lessonType;
	private String lessonTime;
	private String lessonPrice;
	private String lessonTotal;
	private String tutorId;
	private String lessonSample;		//강의 샘플 동영상 
	
	public LessonVo() {
		super();
	}
	
	public LessonVo(String lessonNo, String lessonName, String lessonInfo, String lessonLevel, String lessonType,
			String lessonTime, String lessonPrice, String lessonTotal, String tutorId, String lessonSample) {
		super();
		this.lessonNo = lessonNo;
		this.lessonName = lessonName;
		this.lessonInfo = lessonInfo;
		this.lessonLevel = lessonLevel;
		this.lessonType = lessonType;
		this.lessonTime = lessonTime;
		this.lessonPrice = lessonPrice;
		this.lessonTotal = lessonTotal;
		this.tutorId = tutorId;
		this.lessonSample = lessonSample;
	}

	public String getLessonNo() {
		return lessonNo;
	}

	public void setLessonNo(String lessonNo) {
		this.lessonNo = lessonNo;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonInfo() {
		return lessonInfo;
	}

	public void setLessonInfo(String lessonInfo) {
		this.lessonInfo = lessonInfo;
	}

	public String getLessonLevel() {
		return lessonLevel;
	}

	public void setLessonLevel(String lessonLevel) {
		this.lessonLevel = lessonLevel;
	}

	public String getLessonType() {
		return lessonType;
	}

	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public String getLessonPrice() {
		return lessonPrice;
	}

	public void setLessonPrice(String lessonPrice) {
		this.lessonPrice = lessonPrice;
	}

	public String getLessonTotal() {
		return lessonTotal;
	}

	public void setLessonTotal(String lessonTotal) {
		this.lessonTotal = lessonTotal;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getLessonSample() {
		return lessonSample;
	}

	public void setLessonSample(String lessonSample) {
		this.lessonSample = lessonSample;
	}

	@Override
	public String toString() {
		return "LessonVo [lessonNo=" + lessonNo + ", lessonName=" + lessonName + ", lessonInfo=" + lessonInfo
				+ ", lessonLevel=" + lessonLevel + ", lessonType=" + lessonType + ", lessonTime=" + lessonTime
				+ ", lessonPrice=" + lessonPrice + ", lessonTotal=" + lessonTotal + ", tutorId=" + tutorId + "]";
	}
	
	
}
