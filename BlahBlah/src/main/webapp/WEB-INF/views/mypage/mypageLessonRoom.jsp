<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
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
    <title>내 강의실</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
    <style>
        textarea.autosize { min-height: 50px; }
    </style>
  </head>

  <body>
    <script> 
        // textarea 크기 자동 조절
        function resize(obj) {
          obj.style.height = "1px";
          obj.style.height = (12+obj.scrollHeight)+"px";
        }
    </script>  
    <script type="text/javascript">
    function dicFunction(){
		window.open('dictionary', '사전', 'top=150, left=1000, width=320px, height=250px, status=no, menubar=no, toolbar=no, resizable=no');

   }
    </script>  
   <!--================ Start Header Menu Area =================-->
   <jsp:include page="../common/menu-header.jsp" />
  <!--================ End Header Menu Area =================-->

    <!--================ Start Course Details Area =================-->
    <section class="course_details_area section_gap">
    <div class="container">
            <h1 class="title">강의 보기</h1>
            <div class="row">
                <div class="col-lg-8 course_details_left">
                    <div class="" style="width: 100%; padding: 20% 39%; background-color: cornflowerblue;">
                       	<%-- <a href="https://192.168.130.31:8443/controller/chatting?userId=${userId}">강의 시작</a> --%>
                    </div>
                    <div class="content_wrapper">
                        <!-- <h4 class="title">자료실</h4>
                        <div class="content">
                            <a href="#" class="genric-btn primary radius">download</a>
                        </div> -->

                        <h4 class="title">강의 피드백</h4>
                        <div class="content">
                            <ul class="course_list">
                                <li class="justify-content-between d-flex">
                                    <p>First Lesson</p>
                                    <a class="primary-btn text-uppercase" href="#">View Details</a>
                                </li>
                                <li class="justify-content-between d-flex">
                                    <p>Second Lesson</p>
                                    <a class="primary-btn text-uppercase" href="#">View Details</a>
                                </li>
                                <li class="justify-content-between d-flex">
                                    <p>Getting Know about HTML</p>
                                    <a class="primary-btn text-uppercase" href="#">View Details</a>
                                </li>
                                <li class="justify-content-between d-flex">
                                    <p>Tags and Attributes</p>
                                    <a class="primary-btn text-uppercase" href="#">View Details</a>
                                </li>
                                <li class="justify-content-between d-flex">
                                    <p>Basics of CSS</p>
                                    <a class="primary-btn text-uppercase" href="#">View Details</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>


                <div class="col-lg-4 right-contents">
                    <ul>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Course Name </p>
                                <span class="or">기초 회화 수업</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Trainer’s Name</p>
                                <span class="or">George Mathews</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Level </p>
                                <span class="genric-btn primary small">normal</span>
                            </a>
                        </li>
                    </ul>
                    <h4 class="title">Memo</h4>
                    <div class="feedeback">
                        <textarea name="memo" class="autosize" style="width: 100%;" onkeydown="resize(this)" onkeyup="resize(this)" placeholder=" 수업 내용 필기"></textarea>
                        <a href="#" class="primary-btn2 text-uppercase enroll rounded-0 text-white">Save Memo</a>
                    </div>
                   	<!-- 사전 추가 -->
					<h4 class="title">사전</h4>
					<a class="justify-content-between d-flex" onclick="dicFunction();">
                           <p>단어 찾기</p>
                           <span class="genric-btn primary small">dictionary</span>
                    </a>

                     <h4 class="title">진도율</h4>

                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-2" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0"
                             aria-valuemax="100"></div>
                        </div>
                    </div>
                    <h4 class="title">자료실</h4>
                    <ul>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>study.pptx</p>
                                <span class="genric-btn primary small">download</span>
                            </a>
                        </li>
                    </ul>
                    </div>
            </div>
        </div>
    </section>
    <!--================ End Course Details Area =================-->

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