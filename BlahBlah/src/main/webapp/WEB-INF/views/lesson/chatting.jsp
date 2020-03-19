<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>화상채팅</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script>
	var url = window.location.host;//웹브라우저의 주소창의 포트까지 가져옴
	var pathname = window.location.pathname; /* '/'부터 오른쪽에 있는 모든 경로*/
	var appCtx = pathname.substring(0, pathname.indexOf("/",2));
	var root = url+appCtx;
	alert("루트 : "+url+"\n${userID} 입장");
	/* webRtc를 적용하기 위한 기본설정  */
	
	//webRtc에 필요한 변수를 지정
	var webrtc_capable=true;						//브라우저가 webrtc를 지원하는지 여부
	var rtc_peer_connection=null;					//peer간의 통신을 할 수 있게 하는 객체
	var rtc_session_description=null;				//webrtc에서 유지하는 session객체
	var get_user_media=null;						//현재브라우저를 실행하는 컴퓨터의 video,audio디바이스 가져오는 것
	var connect_stream_to_src=null;					//비디오관련 stream을 video태그에 연결
	var stun_server="stun.1.google.com:19302";		//구글 공개용 stun 서버
													//p2p통신을 위해 서로간의 사설 ip주소를 확인시켜주는 서버 
	// 선언한 변수에 값 세팅하기
	/* 웹 표준 */
	if(navigator.getUserMedia){
		alert("standard browser");
		// 브라우저가 알아서 연결 정보 삽입
		rtc_peer_connection = RTCPeerConnection;
		rtc_session_description = RTCSessionDescription;	// session 정보
		// 로컬의 미디어 데이터를 불러옴
		get_user_media = navigator.getUserMedia.bind(navigator);	
		connect_stream_to_src=function(media_stream, media_element){
			media_element.srcObject = media_stream;		// 영상 전송 스트림
			// <video>의 src 속성 삽입
			media_element.play();	// 비디오 실행		
		};
	}
	/* firefox브라우저 */
	else if(navigator.mozGetUserMedia){
		alert("firefox browser");
		rtc_peer_connection = mozRTCPeerConnection;
		rtc_session_description = mozRTCSessionDescription;
		// 로컬의 미디어 데이터를 불러옴
		get_user_media = navigator.mozGetUserMedia.bind(navigator);
		connect_stream_to_src=function(media_stream,media_element){
			media_element.mozSrcObject=media_stream;//영상을 전송하는 스트림
			//<video>태그 src 속성 값 삽입
			media_element.play();	//video 실행
		};
		stun_server="74.125.31.127:19302";
	}
	/* 크롬 브라우저 */
	else if(navigator.webkitGetUserMedia){
		alert("chrome browser");
		rtc_peer_connection = webkitRTCPeerConnection;
		rtc_session_description = webkitRTCSessionDescription;
		get_user_media = navigator.webkitGetUserMedia.bind(navigator);	//로컬의 미디어 데이터를 불러옴
		connect_stream_to_src=function(media_stream,media_element){
			media_element.src = webkitURL.createObjectURL(media_stream);	//영상을 전송하는 스트림
			//<video>태그 src 속성에 값을 넣는 것
			media_element.play();//video태그 실행
		};
	}
	else{
		//현재 문서를 '안전'하게 불러온 경우가 아니라면 navigator.mediaDevices는 undefined이므로 getUserMedia()도 사용할 수 없습니다
		// -> http 이용해서 웹소켓 통신 시도 할때 undefined가 뜬 이유가..... https 꼭 사용!
		alert("지원 : "+navigator.getUserMedia);
		alert("이 브라우저는 화상채팅을 지원하지 않습니다.");
	}
</script>
<!-- 여기까지 webRtc를 적용하기 위한 기본설정 -->
<script>
	/* 실제 화상 통신 구현 */
	var call_token="${userID}";	//사용자를 구분하기 위한 변수
	var signaling_server;		// 화상채팅시 정보 주고받을 서버 -> websocket 활용
	var peer_connect;			//실직적인 연결 정보를 저장할 객체
	
	//페이지가 로드되면 변수들을 세팅하는 함수 구현
	/* ice : Interactive Connectivity Establishment 
	       두 단말이 서로 통신할 수 있는 최적의 경로를 찾을 수 있도록 도와주는 프레임워크
	  -> ICE는 두 단말 간의 제안 및 수락 모델로 생성되는 실시간 UDP 미디어 스트림을 송수신하기 위한 NAT Traversal 기술이지만 
	  	 TCP 전송 프로토콜에도 적용 가능
	   ICE는 STUN과 TURN을 활용하는 프레임워크로 SDP 제안&수락 모델에 적용 가능 
	*/
	function start(){
		peer_connect = new rtc_peer_connection({
			"iceServers" : [
				{
					"url" : "stun:"+stun_server
				}
			]
		});
		// p2p 접속 경로
		/* onicecandidate : 로컬 ICE 에이전트가 signaling 서버를 통해 원격 피어에게 메세지를 전달할 필요가 있을 때마다 발생 */
		peer_connect.onicecandidate = function(ice_event){
			if(ice_event.candidate){
				signaling_server.send(JSON.stringify({
					token:call_token,
					type:"new_ice_candidate",
					candidate:ice_event.candidate
				}));
			}
		};
		// 자신의 영상을 브라우저에 세팅
		setup_video();
		// 상대방 영상 세팅
		peer_connect.onaddstream = function(event){
			connect_stream_to_src(event.stream, document.getElementById("remote_video"));
			$("#loading_state").hide();
			$("#open_call_state").show();
		}
		// 메세지를 주고받게 해주는 서버 등록 : websocket
		signaling_server = new WebSocket("wss://sclass.iptime.org:8443/BlahBlah/viewChatting");
		//signaling_server = new WebSocket("wss://"+url+"/controller/viewChatting");
		// 시크널링 서버 설정 onmessage 함수 등록
		signaling_server.onopen = function(){
			// 메세지 처리 함수
			signaling_server.onmessage = caller_signal_handler;
			// 접속을 시그널링 서버에 알림
			signaling_server.send(JSON.stringify({
				token : call_token,
				type:"join"
			}));
		}
		document.title = "연결 대기 중";
		$("#loading_state").html("영상 통화 대기 time");
		
	} 	// 기본 환경 설정 끝
	
	
	var connected=true;		//요청이 왔는지 확인하는 flag;
	// signalingserver에서 온 메세지 처리 함수 설정
	function caller_signal_handler(event){
		var signal = JSON.parse(event.data);	// 서버에서 보낸 메세지 파싱
		if(signal.type == "callee_arrived"){		// 화상 연결 요청이 들어왔을때 처리
			/* 서로 연결을 위해 SDP 객체 생성해서 전송 
				SDP 에는 미디어 설정값(해상도, 코딩값..)이 들어가있음
				createOffer() : 상대방에게 연결하기 위한 값을 생성
				: 생성이 정상적으로 이뤄지면 첫번째 매개변수에 함수를 실행
				: 정상적으로 생성되지 않으면 error 발생 후 두 번째 함수를 실행
				: 두가지 다 callback 함수
			*/
			peer_connect.createOffer(new_description_created, log_error);
		}
		else if(signal.type == "new_ice_candidate"){
			peer_connect.addIceCandidate(new RTCIceCandidate(signal.candidate));
		}
		else if(signal.type=="new_description"){			//p2p간 연결하는 로직***
			peer_connect.setRemoteDescription(new rtc_session_description(
				signal.sdp),function(){
					if(peer_connect.remoteDescription.type=="answer"){
						if(connected){
							if(confirm("화상채팅요청이 들어왔습니다. 허용하시겠습니까?")){
								sendArrived();
							}
							connected=false;
						}
					}
					if(peer_connect.remoteDescription.type=="offer"){
						peer_connect.createAnswer(new_description_created,
								function(){}
						);
					}
				},log_error		
			)
		}
		else if(signal.type=="member"){//현재 접속자를 출력
			var membercontainer=$(".members");
			membercontainer.html("");
			for(var i=0; i<signal.members.length; i++){
				var li=$("<li>");												// li 태그 생성
				var h=$("<h4>").html(signal.members[i]).css("color","gray");	// 자신
				if(call_token!=signal.members[i]){								// 상대방
					h.css("color","blue");
					//h.css("background","transparent");
					h.click(function(){
						if(confirm($(this).html()+"과 연결하시겠습니까?")){
							sendArrived();
						}
					});
				}
				li.html(h);
				membercontainer.append(li);
			}
		}
	}
	//description,sdp를 만들어주는 함수
	function new_description_created(description){
		peer_connect.setLocalDescription(description,function(){
			signaling_server.send(JSON.stringify({
				token:call_token,
				type:"new_description",
				sdp:description
			}));
		},log_error);
	}
	
	//	스트림처리하기
	function setup_video(){
		get_user_media({		// 권한 허용
			"audio":true,//브라우저가 컴퓨터의 sound,video 디바이스를 가져오기
			"video":true
		},function(local_stream){	
			//로컬스트림 연결
			connect_stream_to_src(local_stream,document.getElementById("local_video"));
			//peer_connect에 로컬스트림을 추가
			peer_connect.addStream(local_stream);
		},log_error)
	}
	
	function log_error(error){
		console.log(error);
		alert(error);
	}
	
	function sendArrived(){
		signaling_server.send(JSON.stringify({
			token:call_token,
			type:"callee_arrived"
		}))
	}
</script>
<style>
/* html, body {
	padding: 0px;
	margin: 0px;
	font-family: "Arial", "Helvetica", sans-serif;
} */

#loading_state {
	position: absolute;
	top: 45%;
	left: 0px;
	width: 100%;
	font-size: 20px;
	text-align: center;
}

#open_call_state {
	display: none;
}

#local_video {
	position: absolute;
	top: 10px;
	left: 10px;
	/* width: 160px;
	height: 120px; */
	height: 35%;
	border: 2px solid white;
	background: #333333;
}

#remote_video {
	position: absolute;
	top: 0px;
	left: 0px;
	/* width: 1024px;
	height: 768px; */
	height: 100%;
	width: 100%;
	background: #999999;
}
#membercontainer{
	position: absolute;
	top:90px;
	right:50px;
	/* left:70%; */
}

#membercontainer>ul{
	list-style-type:none;
}
#membercontainer>ul>li>h4{
	cursor:pointer;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
</head>
<body onload="start()">
<!-- <div class="container" style="border: 1px solid black;"> -->
		<div id="membercontainer">
			<ul class="members">
			</ul>
		</div>
	<div id="loading_state">
	</div>
	<div id="open_call_state">
		<video id="remote_video" controls></video>
		<video id="local_video"></video>
		<div id="membercontainer">
			<ul class="members">
			</ul>
		</div>
		
	</div>
<!-- </div> -->
</body>
</html>