<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="icon" href="resources/img/favicon.png" type="image/png" />
<title>Blog Details</title>
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
<style type="text/css">
.lic {
	display: none;
}

.lic2 {
	display: none;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#myinfo").click(function() {
			$(".lic").toggle();
			$(".lic").each(function(i) {
				$(this).animate({
					"top" : 50 * (i + 1) + "px"
				}, 2000);
			});
		});
		$("#myroom").click(function() {
			$(".lic2").toggle();
			$(".lic2").each(function(i) {
				$(this).animate({
					"top" : 50 * (i + 1) + "px"
				}, 2000);
			});
		});
	});
	function CheckForm(){
		if($('#userProfile').val() ==""){ 
			alert("변경할 프로필을 선택해 주세요.");
			return false; 
		} else{ 
			$('#chageProfileForm').submit(); 
		}
	}

	function changePwFunction(){
		var nowPw = $("#nowPw").val().trim();
		var newPw = $("#newPw").val().trim();
		var newPwChk = $("#newPwChk").val().trim();
		console.log(nowPw + "/" +newPw);
		var changePwVal = {
				"nowPw":nowPw,
				"newPw":newPw
		};
		if(nowPw == null || nowPw == "" ){
			alert("현재 비밀번호를 입력해 주세요.");
			$('#nowPw').focus();
		} else if(newPw == null || newPw == ""){
			alert("새 비밀번호를 입력해 주세요.");
			$('#newPw').focus();
		} else if(newPwChk == null || newPwChk == ""){
			$('#pwchk').html('새 비밀번호 확인을 입력해 주세요.').css('color','red');
			$('#newPwChk').focus();
		} else if(newPw != newPwChk){
			$('#pwchk').html('새 비밀번호와 확인이 일치하지 않습니다.').css('color','red');
		} else{
		
			$.ajax({
				type:"post",
				url:"changePw",
				data:JSON.stringify(changePwVal),
				contentType:"application/json",
				dataType:"json",
				success:function(msg){
					if(msg.check == true){
						$('#pwchk').val('');
						alert("비밀번호가 성공적으로 변경되었습니다. \n다시 로그인 해주세요.");
						location.href="logout";
					} else{
						$('#pwchk').val('');
						alert("현재 비밀번호가 일치하지 않습니다.");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
    
		
	function deleteMemberFunction(){
			var delpw = $("#delpw").val().trim();
			var deleteval = {
				"delpw" : delpw
			};
			if(nowPw == null || nowPw == "" ){
				alert("현재 비밀번호를 입력해 주세요.");
				$('#delpw').focus();
			} else{
			$.ajax({
				type : "POST",
				url : "deleteMember",
				data:JSON.stringify(deleteval),
				contentType:"application/json; charset=utf-8;",
				dataType:"text",
				success : function(data) {
					 if(data == "true") {
						alert("회원탈퇴가 성공적으로 처리되었습니다.\n그동안 블라블라를 이용해 주셔서 감사합니다.");
						location.href="logout";
					} else{
						$('#delpw').val('');
						alert('현재 비밀번호가 일치하지 않습니다.');
					} 
				},
				 error:function(request,status,error){
				        console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
				       }
			});
			}
			
		}
</script>
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
							<h2>MyPage</h2>
							<div class="page_link">
								<a href="index.html">Home</a> <a href="#">Mypage</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area section_gap_little">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="blog_right_sidebar">
						<!-- <aside class="single_sidebar_widget search_widget">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search Posts">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button"><i class="ti-search"></i></button>
                                </span>
                            </div>
                            <div class="br"></div>
                        </aside> -->
						<aside class="single_sidebar_widget post_category_widget">
							<!-- <h4 class="widget_title">Post Catgories</h4> -->
							<ul class="nav nav-tabs list cat-list" style="display: block;">
								<li id="myinfo"><a data-toggle="tab" href="#my-info"
									class="d-flex justify-content-between active">
										<h4>내 정보</h4>
								</a></li>
								<li class="lic"><a data-toggle="tab" href="#my-changepw"
									class="d-flex justify-content-between">
										<h5 style="color: #666666">비밀번호 변경</h5>
								</a></li>
								<li class="lic"><a data-toggle="tab" href="#my-delete"
									class="d-flex justify-content-between">
										<h5 style="color: #666666">회원 탈퇴</h5>
								</a></li>
								<li id="myroom"><a data-toggle="tab" href="#my-room-lesson"
									class="d-flex justify-content-between">
										<h4>내 강의실</h4>
								</a></li>
								<li class="lic2"><a data-toggle="tab"
									href="#my-room-lesson" class="d-flex justify-content-between">
										<h5 style="color: #666666">수강 중인 강의</h5>
								</a></li>
								<li class="lic2"><a data-toggle="tab"
									href="#my-room-lesson2" class="d-flex justify-content-between">
										<h5 style="color: #666666">수강 만료된 강의</h5>
								</a></li>
								<li><a data-toggle="tab" href="#my-schedule"
									class="d-flex justify-content-between">
										<h4>스케줄</h4>
								</a></li>
								<li><a data-toggle="tab" href="#my-level"
									class="d-flex justify-content-between">
										<h4>레벨 테스트</h4>
								</a></li>
							</ul>
						</aside>

					</div>
				</div>
				<div class="col-lg-9 posts-list">
					<div class="single-post row">

						<div class="tab-content quotes" style="width: 100%;">
							<!-- 내정보 시작 -->
									<div id="my-info" class="tab-pane fade in active show">
								<h2>${member.memberId }님의정보</h2>
								<span class="tag">${member.memberType }</span>
								<hr>
								<div class="row">
									<div class="col-lg-4">
										<img src="resources/profile/${member.memberPhoto}" onerror="this.src='resources/img/about.png'"
										 alt="" style="width: 17vw; height: 14vw;">
									</div>
									<div class="col-lg-8">
										<small class="input-sm-label">name</small> <input type="text"
											class="single-input-primary"
											value="${member.memberName }" disabled> <small
											class="input-sm-label">email</small> <input type="text"
											class="single-input-primary"
											value="${member.memberEmail }" disabled> <br>
										<a class="primary-btn" href="#" data-toggle="modal"
											data-target="#exampleModal" data-backdrop="static">
											Change Profile<i class="ti-arrow-right ml-1"></i>
										</a>
										<!-- change profile modal -->
										<div class="modal fade" id="exampleModal" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">프로필 사진 변경</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<form:form method="post" id="chageProfileForm" enctype="multipart/form-data"  modelAttribute="uploadFile" action="uploadProfile">
													<div class="modal-body">
													
														<span class="btn-file">
														<input type="file" id="userProfile" name="filesDir">
														</span>
															<p style="color:red; font-weight:bold;">
															<form:errors path="file"></form:errors>
															</p>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Close</button>
														<input type="submit" class="btn btn-warning" value="Save changes">
														<!-- <input type="button" class="btn btn-warning" value="Save changes" onclick="CheckForm();"> -->
													</div>
													</form:form>
												</div>
											</div>
										</div>
										<!-- change profile modal end -->

									</div>
								</div>
							</div>

							<!-- 비밀번호 변경 시작 -->
							<div id="my-changepw" class="tab-pane fade">
								<h2>비밀번호 변경</h2>
								<hr>
								<div style="padding: 30px 70px 30px">
									
										<input class="form-control" type="password" name="" id="nowPw"
											placeholder="현재 비밀번호"><br>
										<br> <input class="form-control" type="password" name="" id="newPw"
											placeholder="새 비밀번호"><br> 
											<input class="form-control" type="password" name="" id="newPwChk"
											placeholder="새 비밀번호 확인"><br>
											<div id="pwchk"></div>
										<div class="text-right">
											<input type="button" value="변경" class="btn primary-btn" onclick="changePwFunction();">
										</div>
								
								</div>
							</div>
							<!-- 비밀번호 변경 끝-->

							<!-- 회원 탈퇴 시작 -->
							<div id="my-delete" class="tab-pane fade">
								<h2>회원 탈퇴</h2>
								<hr>
								<div style="padding: 30px 70px 30px">
									<form action="deleteMember">
										<p>회원탈퇴 진행 시 본인을 포함한 타인 모두 아이디 재사용이나 복구가 불가능합니다.</p>
										<p>그래도 탈퇴하시려면 비밀번호 입력 후 '회원 탈퇴' 버튼을 클릭해주세요.</p>
										<br>
										<br> <input class="form-control" type="password"
											name="memberPw" placeholder="현재 비밀번호" id="delpw"> <br>
										<br>	
										<div class="text-center">
											<input type="button" value="회원 탈퇴" class="btn primary-btn" onclick="deleteMemberFunction();">
										</div>
									</form>	
								</div>
							</div>
							<!-- 회원 탈퇴 끝-->

							<!-- 내정보 끝 -->
							<!-- 내강의실 부분 시작 -->
							<div id="my-room" class="tab-pane fade">
								<h2>내 강의실</h2>
								<hr>
								<p>현재 수강중인 강의 출력/ 수강이 끝난 강의는?</p>
							</div>
							<div id="my-schedule" class="tab-pane fade">
								<h2>스케줄</h2>
								<hr>
								<p>
                                     <div class="container">
                                     	<jsp:include page="../calendar/month-view.jsp" />
                                     </div>
                                </p>
							</div>

							<!-- 수강중인 강의 시작-->
							<div id="my-room-lesson" class="tab-pane fade">
								<h2>수강 중인 강의</h2>
								<hr>
								<div class="container">
									<div class="row">

										<c:choose>
											<c:when test="${empty myclassList}">
												<h4>------- 현재 수강 중인 강의가 없습니다. -------</h4>
											</c:when>
											<c:otherwise>
												<c:forEach items="${myclassList}" var="myclass">
													<c:forEach items="${progressList }" var="progress">
														<c:if test="${progress.lessonNo eq myclass.lessonNo }">
													<div class="col-lg-4 col-sm-12">
														<div class="single_course">
															<div class="course_head">
																<img class="img-fluid img-full"
																	src="resources/img/courses/c1.jpg" alt="" />
															</div>
															<div class="course_content">
																<span class="tag mb-4 d-inline-block">${myclass.lessonType }</span>
																<h4 class="mb-3">
																	<a href="lessonRoom?lessonNo=${myclass.lessonNo}">${myclass.lessonName }</a>
																</h4>
																<%-- <p>${myclass.lessonInfo }</p> --%>
																<c:forEach items="${tutorPhotoList }" var="tutor">
																<c:if test="${myclass.tutorId eq tutor.memberId }">
																<div
																	class="course_meta d-flex justify-content-lg-between align-items-lg-center flex-lg-row flex-column mt-4">
																	<div class="authr_meta">
																		<img src="resources/profile/${tutor.memberPhoto}" onerror="this.src='resources/img/courses/author1.png'" alt="" 
																		style="width: 35px !important;height: 35px; border-radius: 50%; vertical-align: middle" />
																		<span class="d-inline-block ml-2">${myclass.tutorId }</span>
																	</div>
																</div>
																</c:if>
																
																
																</c:forEach>
																<br>			
																<div class="percentage">
																<h5 class="title">진도율</h5>
																	<div class="progress">
																		<div class="progress-bar color-6" role="progressbar"
																			style="width: calc((${progress.myclassRemaincnt }/${progress.myclassTotalcnt })*100%);background-color: #fdc632;" aria-valuenow="${progress.myclassRemaincnt }"
																			aria-valuemin="0" aria-valuemax="${progress.myclassTotalcnt }">
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
														</c:if>
													</c:forEach>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
							<!-- 수강중인 강의 끝-->
							<!-- 수강만료된 강의 시작-->
							<div id="my-room-lesson2" class="tab-pane fade">
								<h2>수강 만료된 강의</h2>
								<hr>
								<table class="table" style="text-align: center;">
									<thead>
										<tr>
											<th scope="col-md-1">강사</th>
											<th scope="col-md-1">분류</th>
											<th scope="col-md-5">강의 이름</th>
											<th scope="col-md-1">Level</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${empty closedmyclassList}">
												<tr>
													<td colspan="4">------- 수강 만료된 강의가 없습니다. -------</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach items="${closedmyclassList}" var="myclosedclass">
													<tr>
														<td>${myclosedclass.tutorId }</td>
														<td>${myclosedclass.lessonType }</td>
														<td>${myclosedclass.lessonName }</td>
														<td>${myclosedclass.lessonLevel }</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>



							</div>
							<!-- 수강만료된 강의 끝-->
							<!-- 내강의실 부분 끝 -->

							<div id="my-schedule" class="tab-pane fade">
								<h2>스케줄</h2>
								<hr>
								<p>주로 캘린더로 자주 쓰이는 것 : jquery datepicker</p>
							</div>

							<div id="my-level" class="tab-pane fade">
								<h2>레벨테스트</h2>
								<hr>
								<p>레벨 테스트를 진행하시겠습니까? or 레벨테스트 결과</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

	<!--================ Start footer Area  =================-->
	<jsp:include page="../common/footer.jsp" />
	<!--================ End footer Area  =================-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
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