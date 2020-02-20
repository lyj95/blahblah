package com.blah.vo;

import org.springframework.stereotype.Component;

@Component(value="vo")
public class NoticeVo {
	
	private int noticeNo;			
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private int noticeView;
	private int noticeImportant;
	
	public NoticeVo() {}
	
	public NoticeVo(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public NoticeVo(int noticeNo, String noticeTitle, String noticeContent, String noticeDate, int noticeView,
			int noticeImportant) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeView = noticeView;
		this.noticeImportant = noticeImportant;
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

	public int getNoticeView() {
		return noticeView;
	}

	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}

	public int getNoticeImportant() {
		return noticeImportant;
	}

	public void setNoticeImportant(int noticeImportant) {
		this.noticeImportant = noticeImportant;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeView=" + noticeView + ", noticeImportant=" + noticeImportant
				+ "]";
	}

}
