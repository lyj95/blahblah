package com.blah.vo;

public class TutorVo {
	private String tutorId;
	private String tutorInfo;
	public TutorVo() {
		super();
	}
	public TutorVo(String tutorId, String tutorInfo) {
		super();
		this.tutorId = tutorId;
		this.tutorInfo = tutorInfo;
	}
	public String getTutorId() {
		return tutorId;
	}
	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}
	public String getTutorInfo() {
		return tutorInfo;
	}
	public void setTutorInfo(String tutorInfo) {
		this.tutorInfo = tutorInfo;
	}
	@Override
	public String toString() {
		return "TutorVo [tutorId=" + tutorId + ", tutorInfo=" + tutorInfo + "]";
	}
	
	
}
