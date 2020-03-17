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
    <title>My Page</title>
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
                <h2>Contact Us</h2>
                <div class="page_link">
                  <a href="index.html">Home</a>
                  <a href="contact.html">Contact</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Contact Area =================-->
    <section class="trainer_area section_gap_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                  <div class="main_title">
                    <h2 class="mb-3">수강중인 강의</h2>
                  </div>
                </div>
              </div>
              <div class="row">
                    <div class="col-lg-4 col-sm-12">
                    <div class="single_course">
                      <div class="course_head">
                        <img class="img-fluid img-full" src="resources/img/courses/c1.jpg" alt="" />
                      </div>
                      <div class="course_content">
                        <span class="tag mb-4 d-inline-block">회화</span>
                        <h4 class="mb-3">
                          <a href="room.html">English Talk</a>
                        </h4>
                        <p>
                          기본 영어 회화 강의 입니다
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
                              <i class="ti-direction  mr-2"></i>
                              <a href="#"> 25 </a>
                            <!-- </span>/
                            <span class="meta_info"> -->
                              /
                              <a href="#"> 35 </a>
                              </span>
                          </div>
                        </div>
                      </div>
                    </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="single_course">
                          <div class="course_head">
                            <img class="img-fluid img-full" src="resources/img/courses/c2.jpg" alt="" />
                          </div>
                          <div class="course_content">
                            <span class="tag mb-4 d-inline-block">시험대비</span>
                            <h4 class="mb-3">
                              <a href="room.html">English Talk</a>
                            </h4>
                            <p>
                              시험 준비 강의 입니다
                            </p>
                            <div
                              class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                            >
                              <div class="authr_meta">
                                <img src="resources/img/courses/author1.png" alt="" />
                                <span class="d-inline-block ml-2">Cameron</span>
                              </div>
					                    
                              
                            </div>
                          </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="single_course">
                          <div class="course_head">
                            <img class="img-fluid img-full" src="resources/img/courses/c2.jpg" alt="" />
                          </div>
                          <div class="course_content">
                            <span class="tag mb-4 d-inline-block">시험대비</span>
                            <h4 class="mb-3">
                              <a href="room.html">English Talk</a>
                            </h4>
                            <p>
                              시험 준비 강의 입니다
                            </p>
                            <div
                              class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                            >
                              <div class="authr_meta">
                                <img src="resources/img/courses/author1.png" alt="" />
                                <span class="d-inline-block ml-2">Cameron</span>
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
                  <nav class="blog-pagination justify-content-center d-flex">
                    <ul class="pagination">
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Previous">
                                <span aria-hidden="true">
                                    <i class="ti-angle-left"></i>
                                </span>
                            </a>
                        </li>
                        <li class="page-item"><a href="#" class="page-link">01</a></li>
                        <li class="page-item active"><a href="#" class="page-link">02</a></li>
                        <li class="page-item"><a href="#" class="page-link">03</a></li>
                        <li class="page-item"><a href="#" class="page-link">04</a></li>
                        <li class="page-item"><a href="#" class="page-link">09</a></li>
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Next">
                                <span aria-hidden="true">
                                    <i class="ti-angle-right"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                </nav>
              </div>
      </section>
      <section class="trainer_area section_gap_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                  <div class="main_title">
                    <h2 class="mb-3">수강 만료된 강의</h2>
                  </div>
                </div>
              </div>
              <div class="row">
                    <div class="col-lg-4 col-sm-12">
                    <div class="single_course">
                      <div class="course_head">
                        <img class="img-fluid img-full" src="resources/img/courses/c1.jpg" alt="" />
                      </div>
                      <div class="course_content">
                        <span class="tag mb-4 d-inline-block">회화</span>
                        <h4 class="mb-3">
                          <a href="room.html">English Talk</a>
                        </h4>
                        <p>
                          기본 영어 회화 강의 입니다
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
                              <i class="ti-direction  mr-2"></i>
                              <a href="#"> 25 </a>
                            <!-- </span>/
                            <span class="meta_info"> -->
                              /
                              <a href="#"> 35 </a>
                              </span>
                          </div>
                        </div>
                      </div>
                    </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="single_course">
                          <div class="course_head">
                            <img class="img-fluid img-full" src="resources/img/courses/c2.jpg" alt="" />
                          </div>
                          <div class="course_content">
                            <span class="tag mb-4 d-inline-block">시험대비</span>
                            <h4 class="mb-3">
                              <a href="room.html">English Talk</a>
                            </h4>
                            <p>
                              시험 준비 강의 입니다
                            </p>
                            <div
                              class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                            >
                              <div class="authr_meta">
                                <img src="resources/img/courses/author1.png" alt="" />
                                <span class="d-inline-block ml-2">Cameron</span>
                              </div>
					                    
                              
                            </div>
                          </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="single_course">
                          <div class="course_head">
                            <img class="img-fluid img-full" src="resources/img/courses/c2.jpg" alt="" />
                          </div>
                          <div class="course_content">
                            <span class="tag mb-4 d-inline-block">시험대비</span>
                            <h4 class="mb-3">
                              <a href="room.html">English Talk</a>
                            </h4>
                            <p>
                              시험 준비 강의 입니다
                            </p>
                            <div
                              class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4"
                            >
                              <div class="authr_meta">
                                <img src="resources/img/courses/author1.png" alt="" />
                                <span class="d-inline-block ml-2">Cameron</span>
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
                  <nav class="blog-pagination justify-content-center d-flex">
                    <ul class="pagination">
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Previous">
                                <span aria-hidden="true">
                                    <i class="ti-angle-left"></i>
                                </span>
                            </a>
                        </li>
                        <li class="page-item"><a href="#" class="page-link">01</a></li>
                        <li class="page-item active"><a href="#" class="page-link">02</a></li>
                        <li class="page-item"><a href="#" class="page-link">03</a></li>
                        <li class="page-item"><a href="#" class="page-link">04</a></li>
                        <li class="page-item"><a href="#" class="page-link">09</a></li>
                        <li class="page-item">
                            <a href="#" class="page-link" aria-label="Next">
                                <span aria-hidden="true">
                                    <i class="ti-angle-right"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    <!--================Contact Area =================-->
    <div class="popular_courses">
        <div class="container">
          
        </div>
      </div>
    <!--================ start footer Area  =================-->
    <jsp:include page="../common/footer.jsp" />
    <!--================ End footer Area  =================-->

    <!--================Contact Success and Error message Area =================-->
    <div id="success" class="modal modal-message fade" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <i class="ti-close"></i>
            </button>
            <h2>Thank you</h2>
            <p>Your message is successfully sent...</p>
          </div>
        </div>
      </div>
    </div>

    <!-- Modals error -->

    <div id="error" class="modal modal-message fade" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <i class="ti-close"></i>
            </button>
            <h2>Sorry !</h2>
            <p>Something went wrong</p>
          </div>
        </div>
      </div>
    </div>
    <!--================End Contact Success and Error message Area =================-->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/popper.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/stellar.js"></script>
    <script src="resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
    <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="resources/js/owl-carousel-thumb.min.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script src="resources/js/jquery.ajaxchimp.min.js"></script>
    <script src="resources/js/mail-script.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="resources/js/gmaps.min.js"></script>
    <script src="resources/js/contact.js"></script>
    <script src="resources/js/theme.js"></script>
  </body>
</html>