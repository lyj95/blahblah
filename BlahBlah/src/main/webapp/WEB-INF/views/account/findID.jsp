<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="resources/img/favicon.png" type="image/png" />
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">

</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<title>아이디 찾기</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
			<form action="${path }/account/memberSearchId" method="post" class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					아이디 찾기
				</span>
                          
				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
					<input class="input100" type="text" name="memberName" id="memberName" placeholder="이름">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="text" name="memberEmail" id="memberEmail" placeholder="이메일">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
				<button type="submit" class="login100-form-btn">찾기</button>
					</div>
				
				<br>
				<br>
				
			</form>	
		</div>
	</div>
	
	
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