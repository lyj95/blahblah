<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="resources/img/favicon.png" type="image/png" />
    <title>Level Test</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
    
  </head>
  
  <script>
  	 function checkTest(){
  		
	  		var radio1 = document.all["q1"];
	  		var radio2 = document.all["q2"];
	  		var radio3 = document.all["q3"];
	  		var radio4 = document.all["q4"];
	  		var radio5 = document.all["q5"];


    		var bCheck1 = false;
    		var bCheck2 = false;
    		var bCheck3 = false;
    		var bCheck4 = false;
    		var bCheck5 = false;
    		
    		for ( var i = 0; i < radio1.length; i++ ) {
	  	  		if( radio1[i].checked == true ) {
	  	  		bCheck1 = true;
	  	  		}
    		}
    		
    		for ( var i = 0; i < radio2.length; i++ ) {
	  	  		if( radio2[i].checked == true ) {
	  	  		bCheck2 = true;
	  	  		}
    		}
    		
    		for ( var i = 0; i < radio3.length; i++ ) {
	  	  		if( radio3[i].checked == true ) {
	  	  		bCheck3 = true;
	  	  		}
    		}
    		
    		for ( var i = 0; i < radio4.length; i++ ) {
	  	  		if( radio4[i].checked == true ) {
	  	  		bCheck4 = true;
	  	  		}
    		}
    		
    		for ( var i = 0; i < radio1.length; i++ ) {
	  	  		if( radio1[i].checked == true ) {
	  	  		bCheck5 = true;
	  	  		}
    		}

    		if( bCheck1 == false || bCheck2 == false || bCheck3 == false || bCheck4 == false || bCheck5 == false){
    		alert("문제를 다 풀어주세요.");
    		
    		return false;
    		} else return true;
  		
  	  }
  		
    	  
  	
  </script>

  <body>
    <!--================ Start Header Menu Area =================-->
	<jsp:include page="../common/menu-header.jsp" />
    <!--================ End Header Menu Area =================-->

    <!--================Home Banner Area =================-->
    <section class="banner_area">
      <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6">
              <div class="banner_content text-center">
                <h2>Level Test</h2>
                <div class="page_link">
                  <a href="main">Home</a>
                  <a href="leveltest/leveltest-start">Level Test</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================ Start Level Test Area =================-->
    <section class="about_area section_gap">
      <div class="container">
		 <div class="row">
            <div class="col-lg-12">
            	<form action="leveltestResult" method="post"  onsubmit="return checkTest()" >
	              <div class="banner_content text-center">

	              <div>
		                <p>
		                  Q1. 	다음 빈 칸에 들어갈 단어를 선택하세요.
		                </p>
		                <h2 class="mt-4 mb-5">
		                  You ______ good-skin.	
		                </h2>
	
							<input type="radio" id="correct" name="q1" value=20>
							<label for="primary-radio">are</label>
	
							<br>						
							
							<input type="radio" id="incorrect" name="q1" value=0>
							<label for="confirm-radio">have</label>
							<br>
							
					</div>
	                <br><br><br><br><br>
	                
	                <div>
		                <p>
		                  Q2. 	다음 우리 말에 대한 영어 문장을 선택하세요.
		                </p>
		                <h2 class="mt-4 mb-5">
		                  	너 살 빠졌다~	
		                </h2>
	
							<input type="radio" id="incorrect" name="q2" value=0>
							<label for="primary-radio">You lose weight.</label>
	
							<br>						
							
							<input type="radio" id="correct" name="q2" value=20>
							<label for="confirm-radio">You lost weight.</label>
							<br>
							
					</div>
	                <br><br><br><br><br>
	                
	                <div>
		                <p>
		                  Q3. 	다음 빈 칸에 들어갈 단어를 선택하세요.
		                </p>
		                <h2 class="mt-4 mb-5">
		                  I don't know why, but my cell phone ___________.
		                </h2>
	
							<input type="radio" id="incorrect" name="q3" value=0>
							<label for="primary-radio">doesn't working</label>
	
							<br>						
							
							<input type="radio" id="correct" name="q3" value=20>
							<label for="confirm-radio">doesn't work</label>
							<br>
							
					</div>
	                <br><br><br><br><br>
	                
	                <div>
		                <p>
		                  Q4. 	다음 우리 말에 대한 영어 문장을 선택하세요.
		                </p>
		                <h2 class="mt-4 mb-5">
		               		   네가 여기에 있다면 내가 저녁 해줬을텐데.
		                </h2>
	
							<input type="radio" id="correct" name="q4" value=20>
							<label for="primary-radio">If you were here, I'd cook you dinner.</label>
	
							<br>						
							
							<input type="radio" id="incorrect" name="q4" value=0>
							<label for="confirm-radio">If you are here, I'll cook you dinner.</label>
							<br>
							
					</div>
	                <br><br><br><br><br>
	                
	                <div>
		                <p>
		                  Q5. 	다음 문장의 올바른 뜻을 선택하세요.
		                </p>
		                <h2 class="mt-4 mb-5">
		                  They bought a bag of potato chips and a can of beer.
		                </h2>
	
							<input type="radio" id="correct" name="q5" value=20>
							<label for="primary-radio">그들은 감자칩 한 봉지와 맥주 한 캔을 샀어.</label>
	
							<br>						
							
							<input type="radio" id="incorrect" name="q5" value=0>
							<label for="confirm-radio">그들은 감자칩 한 봉지와 맥주 한 캔을 가져왔어.</label>
							<br>
							
					</div>
	                <br><br><br><br><br>
	              
	              
	               	
					<div>
					<input type="submit" class="genric-btn primary e-large col-lg-5" value="점수 확인하기" />
					</div>
				
	              </div>              
              </form>
            </div>
          </div>
      </div>
    </section>
    <!--================ End Level Test Area =================-->

    <!--================ Start footer Area  =================-->
    <jsp:include page="../common/footer.jsp" />
    <!--================ End footer Area  =================-->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/popper.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
    <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="resources/js/owl-carousel-thumb.min.js"></script>
    <script src="resources/js/jquery.ajaxchimp.min.js"></script>
    <script src="resources/js/mail-script.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="resources/js/gmaps.min.js"></script>
    <script src="resources/js/theme.js"></script>
  </body>
</html>