package com.blah.vo;

public class MsgVo {
	private int msgNo;
	private String getId;
	private String content;
	private String regdate;
	private int readCk; 		// 읽지 않았으면 0 읽었으면 1
	public MsgVo() {
		super();
	}
	public MsgVo(int msgNo, String getId, String content, String regdate, int readCk) {
		super();
		this.msgNo = msgNo;
		this.getId = getId;
		this.content = content;
		this.regdate = regdate;
		this.readCk = readCk;
	}
	
	public MsgVo(String getId, String content) {
		super();
		this.getId = getId;
		this.content = content;
	}
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getGetId() {
		return getId;
	}
	public void setGetId(String getId) {
		this.getId = getId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadCk() {
		return readCk;
	}
	public void setReadCk(int readCk) {
		this.readCk = readCk;
	}
	@Override
	public String toString() {
		return "MsgVo [msgNo=" + msgNo + ", sendId=" + getId + ", content=" + content
				+ ", regdate=" + regdate + ", readCk=" + readCk + "]";
	}
	
	
	
}
