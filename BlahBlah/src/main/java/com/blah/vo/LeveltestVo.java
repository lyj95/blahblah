package com.blah.vo;

public class LeveltestVo {
	
	private String memberId;
    private int levelScore;
    private String memberLevel;
	
	public LeveltestVo() {
		super();
	}

	public LeveltestVo(String memberId, int levelScore, String memberLevel) {
		super();
		this.memberId = memberId;
		this.levelScore = levelScore;
		this.memberLevel = memberLevel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getLevelScore() {
		return levelScore;
	}

	public void setLevelScore(int levelScore) {
		this.levelScore = levelScore;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	@Override
	public String toString() {
		return "LeveltestVo [memberId=" + memberId + ", levelScore=" + levelScore + ", memberLevel=" + memberLevel
				+ "]";
	}

		
}
