package com.blah.vo;

public class FavVo {
	private String memberId;	//찜한 사람
	private int lessonNo;		//찜한 게시글 번호
	
	public FavVo() {
		super();
	}

	public FavVo(String memberId, int lessonNo) {
		super();
		this.memberId = memberId;
		this.lessonNo = lessonNo;
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

	@Override
	public String toString() {
		return "FavVo [memberId=" + memberId + ", lessonNo=" + lessonNo + "]";
	}
	
	
}
