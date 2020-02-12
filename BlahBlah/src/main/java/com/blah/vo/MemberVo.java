package com.blah.vo;

public class MemberVo {
	private String memberId;
	private String memberPw;
	private String memberType;
	private String memberName;
	private String memberEmail;
	private String memberLevel;
	private String memberPhoto;
	
	public MemberVo() {
		super();
	}
	public MemberVo(String memberId, String memberPw, String memberType, String memberName, String memberEmail,
			String memberLevel, String memberPhoto) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberType = memberType;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberLevel = memberLevel;
		this.memberPhoto = memberPhoto;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getMemberPhoto() {
		return memberPhoto;
	}
	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPw=" + memberPw + ", memberType=" + memberType
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberLevel=" + memberLevel
				+ ", memberPhoto=" + memberPhoto + "]";
	}
	
	
}
