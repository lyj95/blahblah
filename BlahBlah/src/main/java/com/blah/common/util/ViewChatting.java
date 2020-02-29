package com.blah.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yaans
 *
 */
public class ViewChatting extends BinaryWebSocketHandler{
	//session관리를 직접 해줘야 함.
	//websocket에 접속한 session 관리하기!
	private static Map<String,WebSocketSession> clients=new HashMap();
	public ViewChatting() {
		// System.out.println("웹소켓 서버를 위한 빈 생성");
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
//		System.out.println("메세지 처리 함수 handleTextMessage 실행 : "+message);
		ObjectMapper mapper=new ObjectMapper();
		// client가 보낸 JSON 데이터를 파싱처리하기 위해 jackson을 사용
		RtcMessage msg=getMessageObject(message);//메세지파싱용 매소드
		session.getAttributes().put("msg",msg);//session객체 보낸 메세지를 저장
		// session 관리를 위해 clients객체에 세션을 추가
		clients.put(msg.getToken(), session);
		sessionChecking();//접속이 종료된 session을 clients에서 삭제함.
		
		/*접속한 회원을 보내기*/
		adminBroadCast();//현재 접속회원 접속자에게 전송하기
		//화면 연결하는 로직 구성
		for(Map.Entry<String, WebSocketSession> client:clients.entrySet()) {
			WebSocketSession s=client.getValue();
			if(!client.getKey().equals(msg.getToken())) {
				try {
					s.sendMessage(new TextMessage(mapper.writeValueAsString(msg)));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void adminBroadCast() {
		ObjectMapper mapper=new ObjectMapper();
		RtcMessage msg=new RtcMessage();
		msg.setToken("admin");
		msg.setType("member");
		msg.setMembers(new ArrayList(clients.keySet()));
		//접속한 client 아이디를 RtcMessage members에 대입
		try {
			for(Map.Entry<String, WebSocketSession> client:clients.entrySet()) {
				client.getValue().sendMessage(new TextMessage(mapper.writeValueAsString(msg)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sessionChecking() {
		Iterator<Map.Entry<String,WebSocketSession>> it=clients.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, WebSocketSession> client=it.next();
			if(!client.getValue().isOpen()) {
				it.remove();
			}
		}
	}
	
	/**
	 * 서버단에서 오브젝트 형식을 JSON으로 변환 or JSON 형식을 오브젝트 형식으로 변환
	 * 라이브러리 JacksonJson : 고성능, 구현부분이 많아 클래스 선언만으로 사용 편리
	 * But 표준 라이브러리가 아니기에 프로젝트 적용 시 고려하기
	 * 
	 * 
	 * @param message : JSON 형식으로 들어온다
	 * @return
	 */
	private RtcMessage getMessageObject(TextMessage message) {
		// Jackson ObjectMapper 선언
		ObjectMapper mapper=new ObjectMapper();
		// 변환된 값을 받을 객체
		RtcMessage msg = null;
		try {
			// 객체의 field값과 json을 비교해서 알아서 담아주는 메소드 한줄
			msg = mapper.readValue(message.getPayload(), RtcMessage.class);
			System.out.println("변환된 RTC 메세지 : "+msg.toString());
		}catch(JsonParseException e) {
			e.printStackTrace();
		}catch(JsonMappingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
