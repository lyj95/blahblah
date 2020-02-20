package com.blah.vo;

import java.util.Date;

public class PaymentVo {
	private String memberId;
	private String lessonNo;
	private Date paymentDay;
	private String impUid;
	
	public PaymentVo() {
		super();
	}
	public PaymentVo(String memberId, String lessonNo, Date paymentDay, String impUid) {
		super();
		this.memberId = memberId;
		this.lessonNo = lessonNo;
		this.paymentDay = paymentDay;
		this.impUid = impUid;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLessonNo() {
		return lessonNo;
	}
	public void setLessonNo(String lessonNo) {
		this.lessonNo = lessonNo;
	}
	public Date getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(Date paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getImpUid() {
		return impUid;
	}
	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}
	@Override
	public String toString() {
		return "PaymentVo [memberId=" + memberId + ", lessonNo=" + lessonNo + ", paymentDay=" + paymentDay + ", impUid="
				+ impUid + "]";
	}	
}