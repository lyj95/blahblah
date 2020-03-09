package com.blah.vo;

public class LeveltestVo {
	
	private String memberId;
    private int levelScore;
    private String memeberLevel;
	
	public LeveltestVo() {
		super();
	}

	public LeveltestVo(String memberId, int levelScore, String memeberLevel) {
		super();
		this.memberId = memberId;
		this.levelScore = levelScore;
		this.memeberLevel = memeberLevel;
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

	public String getMemeberLevel() {
		return memeberLevel;
	}

	public void setMemeberLevel(String memeberLevel) {
		this.memeberLevel = memeberLevel;
	}

	@Override
	public String toString() {
		return "LeveltestVo [memberId=" + memberId + ", levelScore=" + levelScore + ", memeberLevel=" + memeberLevel
				+ "]";
	}
	
	
	
	
}
