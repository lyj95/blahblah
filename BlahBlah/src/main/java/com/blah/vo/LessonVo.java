package com.blah.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class LessonVo {
	private int lessonNo;
	private String lessonName;
	private String lessonInfo;
	private String lessonLevel;
	private String lessonType;
	private String lessonDay;
	private String lessonTime;
	private int lessonPrice;
	private int lessonTotal;
	private String tutorId;
	private String lessonSample;		//강의 샘플 동영상 
	private String lessonStart;			//강의 시작 날짜 
	private String memberPhoto;			//멤버 프로필 설정
	
	public LessonVo() {
		super();
	}

	public LessonVo(int lessonNo, String lessonName, String lessonInfo, String lessonLevel, String lessonType,
			String lessonDay, String lessonTime, int lessonPrice, int lessonTotal, String tutorId, String lessonSample,
			String lessonStart, String memberPhoto) {
		super();
		this.lessonNo = lessonNo;
		this.lessonName = lessonName;
		this.lessonInfo = lessonInfo;
		this.lessonLevel = lessonLevel;
		this.lessonType = lessonType;
		this.lessonDay = lessonDay;
		this.lessonTime = lessonTime;
		this.lessonPrice = lessonPrice;
		this.lessonTotal = lessonTotal;
		this.tutorId = tutorId;
		this.lessonSample = lessonSample;
		this.lessonStart = lessonStart;
		this.memberPhoto = memberPhoto;
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

	public String getLessonDay() {
		return lessonDay;
	}

	public void setLessonDay(String lessonDay) {
		this.lessonDay = lessonDay;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public int getLessonPrice() {
		return lessonPrice;
	}

	public void setLessonPrice(int lessonPrice) {
		this.lessonPrice = lessonPrice;
	}

	public int getLessonTotal() {
		return lessonTotal;
	}

	public void setLessonTotal(int lessonTotal) {
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

	public String getLessonStart() {
		return lessonStart;
	}

	public void setLessonStart(String lessonStart) {
		this.lessonStart = lessonStart;
	}
	
	public String getMemberPhoto() {
		return memberPhoto;
	}
	
	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	@Override
	public String toString() {
		return "LessonVo [lessonNo=" + lessonNo + ", lessonName=" + lessonName + ", lessonInfo=" + lessonInfo
				+ ", lessonLevel=" + lessonLevel + ", lessonType=" + lessonType + ", lessonDay=" + lessonDay
				+ ", lessonTime=" + lessonTime + ", lessonPrice=" + lessonPrice + ", lessonTotal=" + lessonTotal
				+ ", tutorId=" + tutorId + ", lessonSample=" + lessonSample + ", lessonStart=" + lessonStart
				+ ", memberPhoto=" + memberPhoto + "]";
	}

		
	
	
}
