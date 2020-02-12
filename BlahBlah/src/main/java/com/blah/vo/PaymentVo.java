package com.blah.vo;

public class PaymentVo {
	private String memberId;
	private String lessonId;
	public PaymentVo() {
		super();
	}
	public PaymentVo(String memberId, String lessonId) {
		super();
		this.memberId = memberId;
		this.lessonId = lessonId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLessonId() {
		return lessonId;
	}
	public void setLessonId(String lessonId) {
		this.lessonId = lessonId;
	}
	@Override
	public String toString() {
		return "PaymentVo [memberId=" + memberId + ", lessonId=" + lessonId + "]";
	}
	
	
}
