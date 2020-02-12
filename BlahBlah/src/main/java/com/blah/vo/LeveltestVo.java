package com.blah.vo;

public class LeveltestVo {
	private int leveltestNo;
	private String leveltestAnswer;
	private String memberID;
	
	public LeveltestVo() {
		super();
	}

	public LeveltestVo(int leveltestNo, String leveltestAnswer, String memberID) {
		super();
		this.leveltestNo = leveltestNo;
		this.leveltestAnswer = leveltestAnswer;
		this.memberID = memberID;
	}

	public int getLeveltestNo() {
		return leveltestNo;
	}

	public void setLeveltestNo(int leveltestNo) {
		this.leveltestNo = leveltestNo;
	}

	public String getLeveltestAnswer() {
		return leveltestAnswer;
	}

	public void setLeveltestAnswer(String leveltestAnswer) {
		this.leveltestAnswer = leveltestAnswer;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "LeveltestVo [leveltestNo=" + leveltestNo + ", leveltestAnswer=" + leveltestAnswer + ", memberID="
				+ memberID + "]";
	}
	
	
}
