<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="resources/img/favicon.png" type="image/png" />
    <title>Edustage Education</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />


<!--================ Start footer Area  =================-->
    <footer class="footer-area section_gap">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 single-footer-widget">
            <h4>Menu</h4>
            <ul>
              <li><a href="leveltest">Level Test</a></li>
              <li><a href="courseList?page=1&perPageNum=6">Course</a></li>
              <li><a href="notice">Notice</a></li>
              <li><a href="qna">QnA</a></li>
            </ul>
          </div>
          <div class="col-lg-9 col-md-6 single-footer-widget">
            <h4>회사정보</h4>
            <ul>
              <li><p class="col-lg-8 col-sm-12 footer-text m-0 text-white">회사명 : 블라블라</p></li>
              <li><p class="col-lg-8 col-sm-12 footer-text m-0 text-white">연락처 : 010-1234-5678</p></li>
              <li><p class="col-lg-8 col-sm-12 footer-text m-0 text-white">이메일 : blahblah.teamproject@gmail.com</p></li>
            </ul>
          </div>
        </div>
        <div class="row footer-bottom d-flex justify-content-between">
          <p class="col-lg-8 col-sm-12 footer-text m-0 text-white">
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;2020 All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </p>
        </div>
      </div>
    </footer>
<!--================ End footer Area  =================-->

 	<script type="text/javascript">
 	<%
                
       if(request.getSession().getAttribute("login") != null) { 
    %>
	$(document).ready(function(){
			getUnread();
			/* getInfiniteUnread(); */
		
	});
	<% } %>
	</script>
