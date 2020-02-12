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
    <title>공지사항</title>
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

    <!--================Home Banner Area : 아래부분은 수정한 부분입니다 =================-->
    <section class="banner_area">
      <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6">
              <div class="banner_content text-center">
                <h2>Q&A</h2>
                <div class="page_link">
                  <p>질문게시판</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Contact Area: 아래부분은 수정한 부분입니다 =================-->
    <section class="contact_area section_gap" style="padding: 6% 10% 10% 10%;">
      <div class="container">
        <div class="row">
          <div class="blog_right_sidebar">
            <h3 class="widget_title">강의를 연장하려면 어떻게 해야하나요?</h3>
            
                <div class="br"></div>
            <div class="row">
            <div class="col-1"></div>
            <div class="col-2">
            <aside class="single_sidebar_widget author_widget">
                <img class="author_img rounded-circle" src="img/blog/author.png" alt="">
                
                <h4>Ericson</h4>
               
              </div>
              <div class="col-1"></div>
              <div class="col-8">
                <p>Boot camps have its supporters andit sdetractors. Some people do not understand why you
                    should have to spend money on boot camp when you can get. Boot camps have itssuppor
                    ters andits detractors.</p>
                
            </aside>
          </div>
        </div>
           
        <div class="br"></div>
           
            <aside class="single-sidebar-widget newsletter_widget">
              <div class="comments-area">
                <h4>01 Comments</h4>
                <div class="comment-list">
                    <div class="single-comment justify-content-between d-flex">
                        <div class="user justify-content-between d-flex">
                            <div class="thumb">
                                <img src="img/blog/c1.jpg" alt="">
                            </div>
                            <div class="desc">
                                
                                <p class="comment" style="padding: 0 0 2% 0;">
                                  나의 강의실에서 해당하는 강의 하단을 보시면 연장하기 버튼을 찾으실 수 있습니다. 
                                </p>
                                <div class="row">&emsp;
                                <h5><a href="#">blahblah123</a></h5>&emsp;
                                <p class="date">20/02/02 18:30 </p>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
 
                <div class="form-group d-flex flex-row mx-auto" style="width: 80%;">
                    <div class="input-group">
                        <div class="input-group-prepend" style="width: 6%;">
                            <div class="input-group-text" style="padding: 0px 15px 0px 15px;"><i class="ti-comment" aria-hidden="true"></i></div>
                        </div>
                        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="답변을 입력하세요" onfocus="this.placeholder = ''" onblur="this.placeholder = '답변을 입력하세요'">
                    </div>
                    <a href="#" class="bbtns" style="background:#ffc107;">summit</a>
                </div>
            </aside>
            <div class="row" style="padding: 5% 2% 2% 2%;">
             
            <a href="#" class="genric-btn primary" onclick ="location.href='QnA.jsp'">목록으로</a>
            <div class="col-8"></div>
            <a href="#" class="genric-btn  info ">수정</a>&emsp;
            <a href="#" class="genric-btn info ">삭제</a>
          </div>
            </div>
           </div>
      </div>
    </section>
    <!--================Contact Area =================-->

    <!--================ start footer Area  =================-->
    <jsp:include page="../common/footer.jsp" />
    <!--================ End footer Area  =================-->


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
