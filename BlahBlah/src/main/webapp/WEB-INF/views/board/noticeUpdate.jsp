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

    <!--================Home Banner Area : 이 아래부분은 수정한 부분입니다. =================-->
    <section class="banner_area">
    	<div class="banner_inner d-flex align-items-center">
			<div class="overlay"></div>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6">
						<div class="banner_content text-center">
							<h2>NOTICE</h2>
							<div class="page_link">
								<p>공지사항</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Contact Area : 아래부분은 수정한 부분입니다. =================-->
    <section class="contact_area section_gap" style="padding: 5% 0;">
		<div class="container">
			<form class="needs-validation" method="post" action="updateNotice">
				<input type="hidden" name="noticeNo" value="${vo.noticeNo}">
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="validationCustom01">제목</label>
						<input type="text" class="form-control" name="noticeTitle" placeholder="제목을 입력하세요"
							value="${vo.noticeTitle}" required>             
					</div>
				</div>
				<div class="mb-10">
					<label for="validationTextarea">내용</label>
					<textarea cols="15" rows="15" class="form-control" name="noticeContent" style="resize: none; margin: 0 0 2% 0 ;"
						placeholder="내용을 입력하세요" required>${vo.noticeContent}</textarea>
				</div>
				<input type="button" class="btn primary-btn" style="float: right;" value="취소"
					onclick="location.href='noticeDetail?noticeNo=${vo.noticeNo}'">
				<input type="submit" class="btn primary-btn" style="float: right;" value="작성 완료">
			</form>
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
