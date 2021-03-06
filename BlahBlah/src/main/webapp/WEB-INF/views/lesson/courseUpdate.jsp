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
    <title>강의게시판</title>
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
                <h2>Course</h2>
                <div class="page_link">
                  <p>강의만들기</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Contact Area =================-->
    <section class="contact_area section_gap" style="padding: 6% 0 10% 0;">
      <div class="container">
        <form class="needs-validation" action="updateCourseRes" method="post" novalidate>
				<div class="form-group row">
					<label for="lessonName" class="col-sm-2 col-form-label">강의명</label>
					<div class="col-sm-6 lg-6">
					<input type="hidden" id="lessonNo" name="lessonNo" value="${vo.lessonNo }"/>
						<input type="text" class="form-control" id="lessonName" name="lessonName" value="${vo.lessonName }"required>
					</div>
				</div>
				<div class="form-group row">
              <div class="col-sm-2">강의레벨</div>
					<div class="default-select" id="lessonLevel">		
					<select class="nice-select" tabindex="0" id="lessonLevel" name="lessonLevel">
	                     <option id="lessonLevel" value="상">상</option>
	                     <option id="lessonLevel" value="중">중</option>
	                     <option id="lessonLevel" value="하">하</option>
						</select>	
					</div>
				</div>
            <div class="form-group row">
              <div class="col-sm-2">강의목표</div>
					<div class="default-select" id="lessonType">
						<select class="nice-select" tabindex="0" id="lessonType" name="lessonType">
	                     <option id="lessonType" value="SPEAKING">자유회화</option>
	                     <option id="lessonType" value="LICENSE">시험대비</option>
						</select>						
					</div>
				</div>           

            <div class="form-group row">
              <label for="lessonTime" class="col-sm-2 col-form-label">강의시간</label>
              <div class="col-sm-3 lg-3">
                <input type="text" class="form-control" name ="lessonTime" id="lessonTime" value="${vo.lessonTime }">
              </div>
            </div>
            <div class="form-group row">
              <label for="lessonPrice" class="col-sm-2 col-form-label">수강료 (4주 기준)</label>
              <div class="col-sm-3 lg-3">
                <input type="text" class="form-control" name ="lessonPrice" id="lessonPrice" value="${vo.lessonPrice }">                
              </div>
            </div>
            
              <div class="mb-10">
              <label for="lessonInfo">강의정보</label>
              <textarea colspan =15 rows=15 class="form-control " name="lessonInfo" id="lessonInfo" style="resize: none; margin: 0 0 2% 0 "; required>${vo.lessonInfo }</textarea>
            </div>
          <button type="submit" value="submit" class="btn primary-btn" style="float: right;">작성완료</button>
        </form>
      </div>

    </section>
    <!--================Contact Area =================-->

    <!--================ start footer Area  =================-->
    <jsp:include page="../common/footer.jsp" />
    <!--================ End footer Area  =================-->
	<script type="text/javascript">
		$("#lessonLevel").val("${vo.lessonLevel}").prop("selected", true);
		$("#lessonType").val("${vo.lessonType}").prop("selected", true);

	</script>

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
