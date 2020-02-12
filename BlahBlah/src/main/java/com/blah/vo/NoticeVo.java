package com.blah.vo;

public class NoticeVo {
	private int noticeNo;			
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private String noticeView;		//조회수
	public NoticeVo() {
		super();
	}
	public NoticeVo(int noticeNo, String noticeTitle, String noticeContent, String noticeDate, String noticeView) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeView = noticeView;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(String noticeView) {
		this.noticeView = noticeView;
	}
	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeView=" + noticeView + "]";
	}
	
	
}
