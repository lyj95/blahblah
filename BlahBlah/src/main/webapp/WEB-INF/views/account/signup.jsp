<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" 
		src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
function signup(){
	var memberId = $("#memberId").val().trim();
	var memberPw = $("#memberPw").val().trim();
	
	console.log(memberId + "/" + memberPw);
	
	
	if (memberId == null || memberId == "" || memberPw == null || memberPw == ""){
		alert("ID 및 PW를 확인해 주세요");
	} else {
		$.ajax({
			type:"post",
			url:"ajaxlogin",
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		        	
		    },
			data: JSON.stringify(loginVal),
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


$(document).ready(function() {
 $("#idchk").unbind("click").click(function(e) {
  e.preventDefault();
  fn_userIDCheck();
 });
});
 
function fn_userIDCheck() {
	var f = document.Reg_form;
	var memberId = document.getElementById('memberId').value;
	if (memberId == "") {
		alert("아이디를 입력하세요.");
	}  else {
		console.log("ajaxtest1");
		console.log("memberId:"+memberId);

		        		var data2 = {memberId: memberId};

		        		var data = JSON.stringify(data2);
		console.log(data);
		$.ajax({ 
			type : "POST",
			url : "idchk",
			dataType : "json",
			data : {"memberId" : $("#memberId").val()},
			success : function(data) {
				console.log(data);
				if (data != '0') {
					alert("이미 가입된 ID입니다 .다른 ID를 입력해주세요");
				} else {
					alert("사용가능한 아이디입니다.");
				}
				if (data != null) {
					console.log("로그 내용2" + data);
				}
			},
			error : function(error, a, b) {
				console.log(error);
				console.log(a);
				console.log(b);
			}
		});
	}
}

$(function(){

	//비밀번호 확인
		$('#check_password').blur(function(){
		   if($('#memberPw').val() != $('#check_password').val()){
		    	if($('#check_password').val()!=''){
			    alert("비밀번호가 일치하지 않습니다.");
		    	    $('#check_password').val('');
		          $('#check_password').focus();
		       }
		    }
		})  	   
	});

</script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="resources/signup/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="resources/signup/css/style.css">
</head>
<body>

    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">회원가입</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="memberName" placeholder="이름"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="ID" id="memberId" placeholder="아이디"/>
                        </div>
                        <div class="form-group">
                       
                        	<input type="button"  name="idchk" id="idchk" value="아이디 중복 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="memberPw" placeholder="비밀번호"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="check_password" id="check_password" placeholder="비밀번호 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="memberEmail" placeholder="이메일"/>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="회원가입"/>
                        </div>
                    </form>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="resources/signup/vendor/jquery/jquery.min.js"></script>
    <script src="resources/signup/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>