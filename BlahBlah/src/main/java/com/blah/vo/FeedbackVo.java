package com.blah.vo;

public class FeedbackVo {
	int lessonNo;
	String memberId;
	String classDate;
	String feedbackTxt;
	
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
	public String getClassDate() {
		return classDate;
	}
	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}
	public String getFeedbackTxt() {
		return feedbackTxt;
	}
	public void setFeedbackTxt(String feedbackTxt) {
		this.feedbackTxt = feedbackTxt;
	}
	
	@Override
	public String toString() {
		return "FeedBackVo [lessonNo=" + lessonNo + ", memberId=" + memberId + ", classDate=" + classDate
				+ ", feedbackTxt=" + feedbackTxt + "]";
	}
	
}
