<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
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
                            <input type="text" class="form-input" name="name" id="name" placeholder="이름"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="아이디"/>
                        </div>
                        <div class="form-group">
                        	<input type="button" name="idchk" id="idchk" value="아이디 중복 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="비밀번호"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="check_password" id="check_password" placeholder="비밀번호 확인"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="이메일"/>
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