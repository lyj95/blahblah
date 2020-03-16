<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="icon" href="resources/img/favicon.png" type="image/png" />
<title>Courses</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/flaticon.css" />
<link rel="stylesheet" href="resources/css/themify-icons.css" />
<link rel="stylesheet"
	href="resources/vendors/owl-carousel/owl.carousel.min.css" />
<link rel="stylesheet"
	href="resources/vendors/nice-select/css/nice-select.css" />

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
								<a href="index.html">Home</a> <a href="courses.html">Courses</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================ Start Popular Courses Area =================-->
	<div class="popular_courses section_gap_top" style="padding-top: 2%">
		<div class="container">
			<!-- search box -->
			<div class="blog_right_sidebar">
				<div class="row">

					<div class="single_sidebar_widget search_widget col-8"
						style="left: 20%">
					<form action="SearchKeywordCourse" method="post" id ="searchform">
						<div class="input-group">
							<input type="text" class="form-control" 
								placeholder="Search Course" id="keyword" name="keyword"> 
								<span class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="ti-search" ></i>
								</button>
							</span>
						</div>
					</form>	
						<!-- /input-group -->
						<div class="br"></div>
						<div class="single-sidebar-widget tag_cloud_widget ">
							<!--  <h4 class="widget_title">Tag Clouds</h4>-->
							<ul class="list">
								<li><a href="courseList?page=1&perPageNum=6" id="Newest">최신순</a></li>
								<li><a href="courseOrderByReview?page=1&perPageNum=6" id="OrderByReview">평점순</a></li>
								<li><a href="courseTypeLICENSE" id="LICENSEbtn">시험대비</a></li>
								<li><a href="courseTypeSPEAKING" id="SPEAKINGbtn">자유회화</a></li>
								<li><a href="searchLowLevel" id="LowLevelbtn">초급영어</a></li>
								<li><a href="searchMidLevel" id="MidLevelbtn">중급영어</a></li>
								<li><a href="searchHighLevel" id="HighLevelbtn">상급영어</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<br>
			<br>
			<!-- end search box -->
			<div class="row">
				<!-- ------------- 강의목록 반복되는 부분 ------------ -->
				<c:forEach items="${list}" var="list">
					<div class="single_course col-lg-4 col-sm-12" style="height:38vw">
						<div class="course_head">
							<!-- 강의 사진 -->
							<img class="img-fluid" src="resources/img/courses/c1.jpg" alt=""
								style="width: 100%" />
						</div>
						<div class="course_content"style="height:17vw">
							<!-- 강의 카테고리 -->

							<span class="tag mb-4 d-inline-block">${list.lessonType}</span>
							<span class="tag mb-2 d-inline-block">${list.lessonLevel}</span>
							<c:choose>
								<c:when test="${not empty list.lessonStart }">
									<span class="tag mb-2 d-inline-block" style="background-color:red">수강신청마감</span>
								</c:when>
							</c:choose>
							
							<!-- 강의명 -->
							<h4 class="mb-3">
								<c:choose>
									<c:when test="${not empty list.lessonStart }">
										${list.lessonName}
									</c:when>
									<c:otherwise>
										<a href="courseDetail?lessonNo=${list.lessonNo }">${list.lessonName}</a>
									</c:otherwise>
								</c:choose>
							</h4>

							<!-- 강의소개 -->
							<p>${list.lessonInfo}</p>
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

				<!-- ------------- 강의목록 반복되는 부분 끝 ------------- -->

			</div>
			<c:if test="${orderby eq 1}">
				<nav class="blog-pagination justify-content-center d-flex"
					style="padding: 2.5% 0;">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a
								href="javascript:courseList${pageMaker.makeQuery(pageMaker.startPage -1 )}"
								class="page-link" aria-label="Previous"> <span
									aria-hidden="true"> <i class="ti-angle-left"></i>
								</span>
							</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
						<c:if test="${i>0}">
							<li class="page-item"><a
								href="courseList${pageMaker.makeQuery(i)}" class="page-link">${i}</a>
							</li>
						</c:if>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage gt 0}">
							<li><a class="page-link" aria-label="Next"
								href="javascript:courseList${pageMaker.makeQuery(pageMaker.endPage +1 )}">
									<span aria-hidden="true"> <i class="ti-angle-right"></i>
								</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
			</c:if>
			<c:if test="${orderby eq 2}">
				<nav class="blog-pagination justify-content-center d-flex"
					style="padding: 2.5% 0;">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a
								href="javascript:courseOrderByReview${pageMaker.makeQuery(pageMaker.startPage -1 )}"
								class="page-link" aria-label="Previous"> <span
									aria-hidden="true"> <i class="ti-angle-left"></i>
								</span>
							</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
						<c:if test="${i>0}">
							<li class="page-item"><a
								href="courseOrderByReview${pageMaker.makeQuery(i)}" class="page-link">${i}</a>
							</li>
						</c:if>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage gt 0}">
							<li><a class="page-link" aria-label="Next"
								href="javascript:courseOrderByReview${pageMaker.makeQuery(pageMaker.endPage +1 )}">
									<span aria-hidden="true"> <i class="ti-angle-right"></i>
								</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
			</c:if>
			
			<div class="row" style="padding: 2%"></div>
			<c:if test="${memberType eq 'TUTOR'}">
				<div class="col-md-12 text-right">
					<button type="button" value="write"
						onclick="location.href='insertCourseForm'" class="btn primary-btn">글쓰기
					</button>
				</div>
			</c:if>
		</div>
	</div>
	<!--================ End Popular Courses Area =================-->


	<!--================ Start footer Area  =================-->
	<jsp:include page="../common/footer.jsp" />
	<!--================ End footer Area  =================-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script>

	$("#searchform").submit(function() {

		if ($(this).children("input[name=keyword]").val().length < 1) {
			alert("검색어를 입력해주세요.");
			return false;
		}
		return true;
	});
	</script>
	<script src="resources/js/popper.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script
		src="resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
	<script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="resources/js/owl-carousel-thumb.min.js"></script>
	<script src="resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="resources/js/mail-script.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="resources/js/gmaps.min.js"></script>
	<script src="resources/js/theme.js"></script>

</body>
</html>