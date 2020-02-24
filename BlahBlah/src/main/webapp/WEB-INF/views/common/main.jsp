<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
    <title>메인 페이지</title>
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
                <h2 class="text-uppercase mt-4 mb-5">
                  	블라블라
                </h2>
                <div>
                  <a href="#" class="primary-btn2 mb-3 mb-sm-0" style="font-size:14px;">강의 둘러보기</a>
                  <a href="#" class="primary-btn ml-sm-3 ml-0" style="font-size:15px;">레벨 테스트</a>
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
              <h2 class="mb-3 text-white">사이트 장점</h2>
              <p>
                	사이트 장점
              </p>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="single_feature">
              <div class="icon"><span class="flaticon-student"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">장점1</h4>
                <p>
                  	장점1 설명
                </p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="single_feature">
              <div class="icon"><span class="flaticon-book"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">장점2</h4>
                <p>
                	장점2 설명
                </p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6">
            <div class="single_feature">
              <div class="icon"><span class="flaticon-earth"></span></div>
              <div class="desc">
                <h4 class="mt-3 mb-2">장점3</h4>
                <p>
                	장점3 설명
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
              <div class="single_course">
                <div class="course_head">
                  <img class="img-fluid" src="resources/img/courses/c1.jpg" alt="" />
                </div>
                <div class="course_content">
                  <span class="price">가격</span>
                  <span class="tag mb-4 d-inline-block">강의레벨</span>
                  <h4 class="mb-3">
                    <a href="course-details.html">강의명</a>
                  </h4>
                  <p>
                  	강의설명
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <img src="resources/img/courses/author1.png" alt="" />
                      <span class="d-inline-block ml-2">강사명</span>
                    </div>
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info mr-4">
                        <a href="#"> <i class="ti-user mr-2"></i>25 </a>
                      </span>
                      <span class="meta_info"
                        ><a href="#"> <i class="ti-heart mr-2"></i>35 </a></span
                      >
                    </div>
                  </div>
                </div>
              </div>

              <div class="single_course">
                <div class="course_head">
                  <img class="img-fluid" src="resources/img/courses/c2.jpg" alt="" />
                </div>
                <div class="course_content">
                  <span class="price">가격</span>
                  <span class="tag mb-4 d-inline-block">강의레벨</span>
                  <h4 class="mb-3">
                    <a href="course-details.html">강의명</a>
                  </h4>
                  <p>
                  	  강의설명
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <img src="resources/img/courses/author2.png" alt="" />
                      <span class="d-inline-block ml-2">강사명</span>
                    </div>
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info mr-4">
                        <a href="#"> <i class="ti-user mr-2"></i>25 </a>
                      </span>
                      <span class="meta_info"
                        ><a href="#"> <i class="ti-heart mr-2"></i>35 </a></span
                      >
                    </div>
                  </div>
                </div>
              </div>

              <div class="single_course">
                <div class="course_head">
                  <img class="img-fluid" src="resources/img/courses/c3.jpg" alt="" />
                </div>
                <div class="course_content">
                  <span class="price">가격</span>
                  <span class="tag mb-4 d-inline-block">강의레벨</span>
                  <h4 class="mb-3">
                    <a href="course-details.html">강의명</a>
                  </h4>
                  <p>
                  	강의설명
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <img src="resources/img/courses/author3.png" alt="" />
                      <span class="d-inline-block ml-2">강사명</span>
                    </div>
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info mr-4">
                        <a href="#"> <i class="ti-user mr-2"></i>25 </a>
                      </span>
                      <span class="meta_info"
                        ><a href="#"> <i class="ti-heart mr-2"></i>35 </a></span
                      >
                    </div>
                  </div>
                </div>
              </div>
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
              <h2 class="mb-3" style="color:white;">Best Tutor</h2>
              <p>
              	블라블라의 인기 강사를 만나보세요
              </p>
            </div>
          </div>
        </div>
        <div class="row justify-content-center d-flex align-items-center">
          <div class="col-lg-3 col-md-6 col-sm-12 single-trainer">
            <div class="thumb d-flex justify-content-sm-center">
              <img class="img-fluid" src="resources/img/trainer/t1.jpg" alt="" />
            </div>
            <div class="meta-text text-sm-center">
              <h4>강사명</h4>
              <p class="designation">분야</p>
              <div class="mb-4">
                <p>
                	강사 소개
                </p>
              </div>
              <div>
                <a href="#" class="primary-btn ml-sm-3 ml-0" style="font-size:12px; color:#002347;">강의 보기</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-12 single-trainer">
            <div class="thumb d-flex justify-content-sm-center">
              <img class="img-fluid" src="resources/img/trainer/t2.jpg" alt="" />
            </div>
            <div class="meta-text text-sm-center">
              <h4>강사명</h4>
              <p class="designation">분야</p>
              <div class="mb-4">
                <p>
                	 강사소개
                </p>
              </div>
              <div>
                <a href="#" class="primary-btn ml-sm-3 ml-0" style="font-size:12px; color:#002347;">강의 보기</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-12 single-trainer">
            <div class="thumb d-flex justify-content-sm-center">
              <img class="img-fluid" src="resources/img/trainer/t3.jpg" alt="" />
            </div>
            <div class="meta-text text-sm-center">
              <h4>강사명</h4>
              <p class="designation">분야</p>
              <div class="mb-4">
                <p>
                 	강사소개
                </p>
              </div>
              <div>
                <a href="#" class="primary-btn ml-sm-3 ml-0" style="font-size:12px; color:#002347;">강의 보기</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-12 single-trainer">
            <div class="thumb d-flex justify-content-sm-center">
              <img class="img-fluid" src="resources/img/trainer/t4.jpg" alt="" />
            </div>
            <div class="meta-text text-sm-center">
              <h4>강사명</h4>
              <p class="designation">분야</p>
              <div class="mb-4">
                <p>
                	강사소개
                </p>
              </div>
              <div>
                <a href="#" class="primary-btn ml-sm-3 ml-0" style="font-size:12px; color:#002347;">강의 보기</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================ End Trainers Area =================-->

    <!--================ Start Testimonial Area =================-->
    <div class="testimonial_area section_gap">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="main_title">
              <h2 class="mb-3">Best Review</h2>
              <p>
                	블라블라 회원들의 생생한 수강 후기
              </p>
            </div>
          </div>
        </div>

		<!-- 메인 구현 하시는 분이 나중에 리스트로 후기 6개 띄워주시면 됩니다~! -->
        <div class="row">
          <div class="testi_slider owl-carousel">
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t1.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	매우 유익하고 좋은 시간이었습니다~~
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t2.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	강사님이 너무 좋아요
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t2.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	재미있다
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t2.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	실력이 쑥쑥 늘었습니다
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t2.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	강사님 사랑해요
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="testi_item">
              <div class="row">
                <div class="col-lg-4 col-md-6">
                  <img src="resources/img/testimonials/t2.jpg" alt="" />
                </div>
                <div class="col-lg-8">
                  <div class="testi_text">
                    <h4>ID</h4>
                    <p>
                    	강사님을 만나고 입이 트였어요
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
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
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="resources/js/gmaps.min.js"></script>
    <script src="resources/js/theme.js"></script>
  </body>
</html>