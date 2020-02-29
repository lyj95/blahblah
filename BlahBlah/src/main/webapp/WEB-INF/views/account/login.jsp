<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" 
		src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">



$(function(){ $("#loginChk").hide(); });
function login(){
	var memberId = $("#memberId").val().trim();
	var memberPw = $("#memberPw").val().trim();
	console.log(memberId + "/" + memberPw);
	var loginVal = {
			"memberId":memberId,
			"memberPw":memberPw
			};
	
	if (memberId == null || memberId == "" || memberPw == null || memberPw == ""){
		alert("ID 및 PW를 확인해 주세요");
	} else {
		$.ajax({
			type:"post",
			url:"ajaxlogin",
			data:JSON.stringify(loginVal),
			contentType:"application/json",
			dataType:"json",
			success:function(msg){ 
				if (msg.check == true){
					alert("로그인 성공!");
					location.href="main";
				} else {
					alert("ID 혹은 PW가 잘못되었습니다.");
					$("#loginChk").show();
					$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.");
				}
			},
			error:function(){
				alert("통신 실패");
			}
		});
	}
}


</script>

	<title>로그인</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/login/images/icons/favicon.ico"/>
<!--================"C:/Users/GangNangYee/Desktop/Login_v9/login"===============================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/login/css/main.css">
<!--===============================================================================================-->
</head>

 <body>

	
	<div class="container-login100" style="background-image: url('resources/img/banner/home-banner.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					로그인
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
					<input class="input100" type="text" id="memberId" placeholder="아이디">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="password" id="memberPw" placeholder="비밀번호">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
		
							<input type="button" value="로그인" class="login100-form-btn" id="btn" onclick="login();">
				
				</div>
				
				<div class="text-center p-t-57 p-b-20">
		<a class="text-center p-t-57 p-b-20" href="findidform">아이디 찾기</a>/
		<a class="text-center p-t-57 p-b-20" href="findpwform">비밀번호 찾기</a>
				
				</div>
				
				<div class="text-center p-t-57 p-b-20">
					<span class="txt1" style="font-size:12px;">
						네이버 or 구글 아이디로 로그인
					</span>
				</div>
				
					
				<div id="naver_id_login">
					<a href=naverLogin class="login100-social-item">
					<img src="resources/login/images/icons/icon-naver.png" alt="NAVER">
					</a>
					</div>
					<!-- <a href="#" class="login100-social-item">
						<img src="resources/login/images/icons/icon-google.png" alt="GOOGLE">
					</a> -->
				
			</form>	
		</div>
	</div>
	<script type = "text/javascript" src = "https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 
<div id = "naver_id_login"></div>
	
	<script type="text/javascript">
 		var naver_id_login = new naver_id_login("BxSbElyRDuGu9zuj3eDh", "http://localhost:8787/controller/main" );	// Client ID, CallBack URL 삽입
											// 단 'localhost'가 포함된 CallBack URL
 		var state = naver_id_login.getUniqState();
		
 		naver_id_login.setButton("white", 2, 40);
 		naver_id_login.setDomain("http://localhost:8787/controller/login");	//  URL
 		naver_id_login.setState(state);
 		naver_id_login.setPopup();
 		naver_id_login.init_naver_id_login();
	</script>
	
	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="resources/login/js/main.js"></script>

</body>
</html>