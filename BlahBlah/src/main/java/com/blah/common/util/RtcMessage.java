package com.blah.common.util;
import java.util.List;
import java.util.Map;


/**
 * RTC : Real-Time Communication
 * @author yaans
 *
 */
public class RtcMessage {
	private String token;
	private String type;
	private List<String> members;
	private Sdp sdp;
	private Map<String,String> candidate;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	public Sdp getSdp() {
		return sdp;
	}
	public void setSdp(Sdp sdp) {
		this.sdp = sdp;
	}
	public Map<String, String> getCandidate() {
		return candidate;
	}
	public void setCandidate(Map<String, String> candidate) {
		this.candidate = candidate;
	}
	@Override
	public String toString() {
		return "RtcMessage [token=" + token + ", type=" + type + ", members=" + members + ", sdp=" + sdp
				+ ", candidate=" + candidate + "]";
	}

	
	
}