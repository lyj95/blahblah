package com.blah.vo;

public class ReplyVo {
	private int qnaNo;		//원글 번호
	private String replyDate;
	private String replyContent;
	
	public ReplyVo() {
		super();
	}

	public ReplyVo(int qnaNo, String replyDate, String replyContent) {
		super();
		this.qnaNo = qnaNo;
		this.replyDate = replyDate;
		this.replyContent = replyContent;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Override
	public String toString() {
		return "ReplyVo [qnaNo=" + qnaNo + ", replyDate=" + replyDate + ", replyContent=" + replyContent + "]";
	}
	
	
}
