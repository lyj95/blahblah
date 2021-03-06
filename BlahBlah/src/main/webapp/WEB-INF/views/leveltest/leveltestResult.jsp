<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                  <a href="leveltest/leveltest-start.jsp">Level Test</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

<!--================ Start Level Test Result Area =================-->
    <section class="about_area section_gap">
      <div class="container">
		 <div class="row">
            <div class="col-lg-12">

	              <div class="text-center">
	              
	              	<div>
		                <h3 class="mt-4 mb-5"> 레벨테스트 결과</h3>							
					</div>
	             	<div>
		                <h2 class="mt-4 mb-5"> ${lvo.memberId} 님의 점수는 ${lvo.levelScore}점 입니다. </h2>							
					</div>
					<hr>
					<br><br>
					<div>
		                <h3 class="mt-4 mb-5"> 추천 강의 </h3>							
					</div>
	                	              	             
	              </div>              

            </div>
            
            <!-- 강의목록 시작 -->
           	<c:forEach items="${list}" var="list">
					<div class="single_course col-lg-4 col-sm-12" style="height:36vw">
						<div class="course_head">
							<!-- 강의 사진 -->
							<img class="img-fluid" src="resources/img/courses/c1.jpg" alt=""
								style="width: 100%" />
						</div>
						<div class="course_content"style="height:15.3vw">
							<!-- 강의 카테고리 -->

							<span class="tag mb-4 d-inline-block">${list.lessonType}</span>
							<span class="tag mb-2 d-inline-block">${list.lessonLevel}</span>

							<!-- 강의명 -->
							<h4 class="mb-3">
								<a href="courseDetail?lessonNo=${list.lessonNo }">${list.lessonName}</a>
							</h4>

							<!-- 강의소개 -->
							<div
								class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4">
								<div class="authr_meta">
									<!-- 강사 프로필 사진 -->
									<img src="resources/profile/${list.memberPhoto }" onerror="this.src='resources/img/courses/author1.png'" 
									style="width: 3.5vw; height: 3.5vw; border-radius: 70%;" alt="" />

									<!-- 강사명 -->
									<span class="d-inline-block ml-2"><c:out
											value="${list.tutorId}" /></span>
								</div>

								<!-- ===강의 찜 개수 표시=== -->
								<c:forEach items="${favCountList }" var="favCount">
									<c:if test="${favCount.LESSON_NO eq list.lessonNo }">
										<div class="mt-lg-0 mt-3">
											<span class="meta_info"><i class="ti-heart mr-2" id="heart${list.lessonNo }"></i>${favCount.CNT }</span>
										</div>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>
				</c:forEach>
            <!-- 강의 목록 끝 -->
            </div>
      </div>
    </section>
    <!--================ End Level Test Result Area =================-->

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