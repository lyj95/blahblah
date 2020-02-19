<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
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

    <!--================Home Banner Area : 이 아래부분은 수정한 부분입니다!=================-->
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

    <!--================Contact Area  : 이 아래부분은 수정한 부분입니다!=================-->
    <section class="contact_area section_gap" style="padding: 6% 0 10% 0;">
    	<form method="post" action="noticeUpdateForm">
    		<input type="hidden" name="noticeNo" value="${vo.noticeNo}">
			<div class="container">
				<div class="row">
					<div class="section">
						<div class="b_area">
							<table class="col-12">
								<colgroup>
									<col width="130">
									<col width="390">
									<col width="130">
									<col width="80">
								</colgroup>
								<tbody>
									<tr>
										<td style="background: #f1f4f7;font-weight: bold; font-size: 14px; text-align: center; padding: 1%;">
											제&nbsp;&nbsp;목</td>
										<td colspan="3" class="t_al2"> &nbsp;<b>${vo.noticeTitle}</b></td>
									</tr>
									<tr>
										<td class="t_bc2 t_b0" style="background: #f1f4f7;font-weight: bold; font-size: 14px;
											text-align: center; padding: 1%; ">작성일</td>
										<td class="t_al2 t_b0">&nbsp; ${vo.noticeDate}</td>
										<td col-md-1 lg-1 style="background: #f1f4f7;font-weight: bold; font-size: 14px; text-align: center;
											padding: 1%;">조회수</td>
										<td col-md-1 lg-1 class="t_b0">&nbsp; ${vo.noticeView}</td>
									</tr>
								</tbody>
							</table >
							
							<p class="t_inf"></p>
							
							<div class="text_area" style="padding: 2% 2% 10% 2%;">
								<!-- 내용 출력 -->
								<div class="col"></div>
								<div class="content col-12">
									${vo.noticeContent}
									<div class="col"></div>
								</div>
							</div>
							<div class="br"></div>
							
							<table class="col-12" cellpadding="0" style="padding: 5%; ">
								<colgroup>
									<col width="130">
									<col width="600">
								</colgroup>
								<tbody>
									<tr>
										<td class="t_bc2">이전글</td>
										<c:choose>
											<c:when test="${empty next}">
												<td class="t_al2"><span class="t_asl">이전글이 없습니다.</span></td>
											</c:when>
											<c:otherwise>
												<td class="t_al2 t_b0">
													<span class="t_asl">
														<a href="noticeDetail?noticeNo=${next.noticeNo}">${next.noticeTitle}</a>
													</span>
													<span class="t_asr"></span>
												</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="t_bc2 t_b0">다음글</td>
										<c:choose>
											<c:when test="${empty pre}">
												<td class="t_al2"><span class="t_asl">다음글이 없습니다.</span></td>
											</c:when>
											<c:otherwise>
												<td class="t_al2 t_b0">
													<span class="t_asl">
														<a href="noticeDetail?noticeNo=${pre.noticeNo}">${pre.noticeTitle}</a>
													</span>
													<span class="t_asr"></span>
												</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
	        
				<div class="row"></div>
				
				<div class="row">
					<div class="col-10"></div>
					<input type="submit" value="수정" class="genric-btn info circle" style="float: right;">
					&nbsp;&nbsp;
					<button type="button" class="genric-btn info circle" style="float: right;"
						onclick="location.href='deleteNotice?noticeNo=${vo.noticeNo}'">삭제</button>
				</div>
			</div>
		</form>
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
