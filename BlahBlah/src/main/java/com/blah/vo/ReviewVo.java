package com.blah.vo;

public class ReviewVo {
	private int reviewNo;
	private String memberId;
	private int lessonNo;
	private String reviewTitle;
	private String reviewContent;
	private String reviewDate;
	private int reviewGrade;		//강의 별점
	
	public ReviewVo() {
		super();
	}
	public ReviewVo(String memberId, int lessonNo, String reviewTitle, String reviewContent, String reviewDate,
			int reviewGrade) {
		super();
		this.memberId = memberId;
		this.lessonNo = lessonNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewGrade = reviewGrade;
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
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	@Override
	public String toString() {
		return "ReviewVo [memberId=" + memberId + ", lessonNo=" + lessonNo + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", reviewGrade=" + reviewGrade
				+ "]";
	}
	
	
	
}
