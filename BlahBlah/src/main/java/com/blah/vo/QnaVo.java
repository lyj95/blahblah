package com.blah.vo;

public class QnaVo {
	
	private int qnaNo;
	private String memberId;
	private String qnaTitle;
	private String qnaContent;
	private String qnaDate;
	private String qnaRep; 		//답변여부 (Y /N)
	private String qnaOpen;
	
	public QnaVo() {}

	public QnaVo(int qnaNo, String memberId, String qnaTitle, String qnaContent, String qnaDate, String qnaRep,
			String qnaOpen) {
		super();
		this.qnaNo = qnaNo;
		this.memberId = memberId;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaRep = qnaRep;
		this.qnaOpen = qnaOpen;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaRep() {
		return qnaRep;
	}

	public void setQnaRep(String qnaRep) {
		this.qnaRep = qnaRep;
	}

	public String getQnaOpen() {
		return qnaOpen;
	}

	public void setQnaOpen(String qnaOpen) {
		this.qnaOpen = qnaOpen;
	}

	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", memberId=" + memberId + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaDate=" + qnaDate + ", qnaRep=" + qnaRep + ", qnaOpen=" + qnaOpen + "]";
	}
	
}
