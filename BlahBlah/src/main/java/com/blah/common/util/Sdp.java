package com.blah.common.util;

/**
 * SDP : Session Description Protocol
 * 멀티미디어 세션 파라미터를 협상하는 프로토콜
 * 제안과 수락 모델로 정의 (Offer & Answer Model)
 * 
 * @author yaans
 *	http://wiki.pchero21.com/wiki/SIP_SDP
 */
public class Sdp {
	private String type;
	private String sdp;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSdp() {
		return sdp;
	}
	public void setSdp(String sdp) {
		this.sdp = sdp;
	}
}
