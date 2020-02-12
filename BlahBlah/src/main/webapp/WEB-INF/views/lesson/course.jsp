<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>Courses</title>
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
                <h2>Courses</h2>
                <div class="page_link">
                  <a href="index.html">Home</a>
                  <a href="courses.html">Courses</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================ Start Popular Courses Area =================-->
    <div class="popular_courses section_gap_top">
      <div class="container">
      
       <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="main_title">
              <h2 class="mb-3">강의 목록</h2>
            </div>
          </div>
        </div>
		
		<!-- search box -->
        <div class="search_input" id="search_input_box">        
            <form class="d-flex justify-content-between" method="" action="">
              <input
                type="text"
                class="form-control"
                id="search_input"
                placeholder="Search Here"
              />
              <button type="submit" class="btn"></button>
              <span
                class="ti-search"
                id="close_search"
                title="Close Search"
              ></span>
            </form>          
        </div>
        <!-- end search box -->
        
        <br><br>

        <div class="row">
          <!-- single course -->         
              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c1.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">시험대비</span>
                  
                  <!-- 강의명 -->
                  <h4 class="mb-3">
                    <a href="course-detail.jsp">Custom Product Design</a>
                  </h4>
                  
                  <!-- 강의소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author1.png" alt="" />
                      
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- ===강의 찜 개수 표시=== -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"><i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                  </div>
                </div>
              </div>
			
              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c2.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">영어회화</span>
                  <h4 class="mb-3">
                     <!-- 강의명 -->
                    <a href="course-details.html">Social Media Network</a>
                  </h4>
                  <!-- 강의 소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author2.png" alt="" />
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- 강의 찜 개수 표시 -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"> <i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                    
                  </div>
                </div>
              </div>

              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c3.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">영어회화</span>
                  <h4 class="mb-3">
                  <!-- 강의명 -->
                    <a href="course-details.html">Computer Engineering</a>
                  </h4>
                  <!-- 강의 소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author3.png" alt="" />
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- 강의 찜 개수 표시 -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"> <i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                  </div>
                </div>
              </div>

        </div>
        
        <br><br>
        
        <div class="row">
          <!-- single course -->         
              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c1.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">시험대비</span>
                  
                  <!-- 강의명 -->
                  <h4 class="mb-3">
                    <a href="course-details.html">Custom Product Design</a>
                  </h4>
                  
                  <!-- 강의소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author1.png" alt="" />
                      
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- ===강의 찜 개수 표시=== -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"><i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                  </div>
                </div>
              </div>
			
              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c2.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">영어회화</span>
                  <h4 class="mb-3">
                     <!-- 강의명 -->
                    <a href="lesson/course-details.html">Social Media Network</a>
                  </h4>
                  <!-- 강의 소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author2.png" alt="" />
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- 강의 찜 개수 표시 -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"> <i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                    
                  </div>
                </div>
              </div>

              <div class="single_course col-lg-4 col-sm-12">
                <div class="course_head">
                  <!-- 강의 사진 -->
                  <img class="img-fluid" src="resources/img/courses/c3.jpg" alt="" style="width:100%"/>
                </div>
                <div class="course_content">
                  <!-- 강의 카테고리 -->
                  <span class="tag mb-4 d-inline-block">영어회화</span>
                  <h4 class="mb-3">
                  <!-- 강의명 -->
                    <a href="lesson/course-details.html">Computer Engineering</a>
                  </h4>
                  <!-- 강의 소개 -->
                  <p>
                    One make creepeth man bearing their one firmament won't fowl
                    meat over sea
                  </p>
                  <div
                    class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                  >
                    <div class="authr_meta">
                      <!-- 강사 프로필 사진 -->
                      <img src="resources/img/courses/author3.png" alt="" />
                      <!-- 강사명 -->
                      <span class="d-inline-block ml-2">Cameron</span>
                    </div>
                    
                    <!-- 강의 찜 개수 표시 -->
                    <div class="mt-lg-0 mt-3">
                      <span class="meta_info"> <i class="ti-heart mr-2"></i>35</span>
                    </div>
                    
                  </div>
                </div>
              </div>

        </div>
        
      </div>
    </div>
    <!--================ End Popular Courses Area =================-->


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