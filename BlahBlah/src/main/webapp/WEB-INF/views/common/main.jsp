<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="resources/img/favicon.png" type="image/png" />
    <title>Blah Blah</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
  </head>

  <body>
  
    <!--================ Start Header Menu Area =================-->
	<jsp:include page="../common/header.jsp" />
    <!--================ End Header Menu Area =================-->

    <!--================ Start Home Banner Area =================-->
    <section class="home_banner_area">
      <div class="banner_inner">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <div class="banner_content text-center">
                <p class="text-uppercase">
                  1:1 영어 회화 화상 과외
                </p>
                <!-- <h2 class="text-uppercase mt-4 mb-5">
                  	BLAH BLAH
                </h2> -->
                
                <h2 class="text-uppercase mt-4 mb-5">
                  	<img src="resources/img/blahblah.png" alt="BLAH BLAH">
                </h2>
                <br>
                
                <div>
                  <a href="courseList?page=1&perPageNum=6" class="primary-btn2 mb-3 mb-sm-0" style="font-size:14px;">강의 둘러보기</a>
                  <a href="leveltestStart" class="primary-btn ml-sm-3 ml-0" style="font-size:15px;">레벨 테스트</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================ End Home Banner Area =================-->
    
    <!--================ Start Feature Area =================-->
    <section class="feature_area section_gap_top title-bg">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="main_title">
              <h2 class="mb-3 text-white">블라블라의 장점</h2>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="single_feature" style="height:30vh;">
              <div class="icon"><span class="flaticon-student"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">1:1 개인별 맞춤 강의</h4>
                <p>
                  	1:1 개인별 강의를 통해 맞춤으로 진도 및 난이도 조절이 가능합니다.
                </p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="single_feature" style="height:30vh;">
              <div class="icon"><span class="flaticon-book"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">레벨테스트를 통한 강의 추천</h4>
                <p>
                	레벨테스트 결과를 바탕으로 수준별 강의를  추천받을 수 있습니다.
                </p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="single_feature" style="height:30vh;">
              <div class="icon"><span class="flaticon-earth"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">장소제약 없는 온라인 진행</h4>
                <p>
                	온라인을 통해 블라블라의 모든 강의를 원하는 장소에서 수강가능합니다.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================ End Feature Area =================-->

    <!--================ Start Popular Courses Area =================-->
    <div class="popular_courses" style="padding-top: 140px; padding-bottom: 80px;">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="main_title">
              <h2 class="mb-3">Best Course</h2>
              <p>
              	블라블라의 인기 강의를 만나보세요
              </p>
            </div>
          </div>
        </div>
        <div class="row">
          <!-- single course -->
          <div class="col-lg-12">
            <div class="owl-carousel active_course">
          <c:forEach items="${lessonlist}" var="list">
              <div class="single_course">
                <div class="course_head">
                 <img class="img-fluid" src= "resources/img/courses/c1.jpg" alt="" />
                </div>
                <div class="course_content">
                  <span class="price">${list.lessonPrice }</span>
                  <span class="tag mb-4 d-inline-block">${list.lessonLevel}</span>
                  <h4 class="mb-3">
                    <a href="courseDetail?lessonNo=${list.lessonNo }">${list.lessonName}</a>
                  </h4>
                  <p>
                  	${list.lessonInfo}
                  </p>
                  <div class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4">
                    <div class="row" >
                    	<div class="authr_meta" >
                      <img src="resources/profile/${list.memberPhoto }" style="width: 3.5vw; height: 3.5vw;object-fit: cover;  object-position: top; border-radius: 50%;" onerror="this.src='resources/img/courses/author1.png'" alt="" />
                      <span class="authr_meta d-inline-block ml-2" >${list.tutorId}</span>
                   	 </div>
                    </div>
                </div>
              </div>
              </div>
		 </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--================ End Popular Courses Area =================-->

    <!--================ Start Trainers Area =================-->
    <section class="feature_area section_gap_top title-bg">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="main_title">
              <h2 class="mb-3" style="color:white;">Best Review</h2>
              <p>
              	블라블라 회원들의 생생한 수강 후기
              </p>
            </div>
          </div>
        </div>      
        
        <div class="row">
          <div class="testi_slider owl-carousel">
           <c:forEach items="${reviewlist}" var="list">
            <div class="testi_item" style="background:white; height:14vw;">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                 <img src="resources/profile/${list.memberPhoto}" onerror="this.src='resources/img/about.png'" style="width:121px;height:94px;"/>
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>${list.memberId}</h4>
                    <p >
                    <a href="courseDetail?lessonNo=${list.lessonNo }" style="color:gray;"> ${list.reviewContent} </a>                	                   	
                    </p>
                  </div>
                </div>
              </div>
            </div>
        </c:forEach>    
        </div>
      </div>
    </section>
    <!--================ End Trainers Area =================-->

    
    <!-- ================================= 챗봇 ======================================= -->
    <div id="frogue-container" class="position-right-bottom"
      data-chatbot="2864ec5a-3099-4752-8fa4-45df068b6e4e"></div>
      
	<script>
	(function(d, s, id){
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) {return;}
	    js = d.createElement(s); js.id = id;
	    js.src = "https:\/\/danbee.ai/js/plugins/frogue-embed/frogue-embed.min.js";
	    fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'frogue-embed'));
	</script>
	
	<!-- ================================= 챗봇 ======================================= -->
	
    <!--================ End Testimonial Area =================-->

    <!--================ Start footer Area  =================-->
    <jsp:include page="footer.jsp" />
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
    <script src="resources/js/theme.js"></script>
  </body>
</html>