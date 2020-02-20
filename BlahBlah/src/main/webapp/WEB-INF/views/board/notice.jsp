<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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

<script type="text/javascript">
/*	
	function search() {
		
		var searchCondition = $("#searchCondition").val().trim();
		var searchContent = $("#searchContent").val().trim();
		
		if (searchCondition == "분류") {
			alert("분류를 선택하세요.");
			
		} else if (searchContent == null) {
			alert("검색어를 입력하세요.");
			
		} else if (searchCondition == "제목" && searchContent != null) {
			$.ajax({
				type:"post",
				url:"searchByTitle",
				
				data:JSON.stringify(searchContent),
				contentType:"appliction/json",
				dataType:"json",
				success: function(msg) {
					
				},
				errr:function(){
					alert("통신실패");
				}
			})
		} else if (searchCondition == "내용" && searchContent != null) {
			$.ajax({
				type:"post",
				url:"searchByContent",
				
				data:JSON.stringify(searchContent),
				contentType:"appliction/json",
				dataType:"json",
				success: function(msg) {
					location.href="searchedList";
				},
				errr:function(){
					alert("통신실패");
				}
			})
		}	
	}
*/

	function changeListOrder() {
		
		if (document.getElementById("orderBy").options[document.getElementById("orderBy").selectedIndex].text=="최신순") {
			document.form.action="notice";
			document.form.submit();
		} else {
			document.form.action="noticeOrderByNoticeView";
			document.form.submit();
		}
	}
</script>

<body>
  <!--================ Start Header Menu Area =================-->
	<jsp:include page="../common/menu-header.jsp" />
  <!--================ End Header Menu Area =================-->

  <!--================Home Banner Area : 이 아래영역은 수정한 부분입니다!=================-->
  <section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6">
            <div class="banner_content text-center">
              <h2>NOTICE</h2>s
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

  <!--================Contact Area : 이 아래 영역은 수정한 부분입니다!= =================-->
  <section class="contact_area section_gap" style="padding: 5% 0;">
  	<form name="form" method="post" action="">
		<div class="container">
			<div class="row">
				<div>
					<select class="input-group-prepend" name="orderBy" id="orderBy" onchange="changeListOrder()">
						<option value="noticeNo" selected="selected">최신순</option>
						<option value="noticeView">조회순</option>
					</select>
				</div>
				
				<div class="row" style="padding: 3% 0;"></div>
				
				<table class="table" style="text-align:center;">
					<thead>
						<tr>
							<th scope="col">글번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody id="mainContent">
						<c:choose>
							<c:when test="${empty noticeList}">
								<tr>
									<td colspan="4" align="center">------------------------- 작성된 글이 없습니다 -------------------------</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${noticeList}" var="vo">
									<c:choose>
										<c:when test="${vo.noticeImportant eq 1}">
											<tr style="background-color:#ECF7F9; font-weight:bold;">
												<th scope="row">${vo.noticeNo}</th>
												<c:choose>
													<c:when test="${vo.noticeDate eq sysdate}">
														<td><a href="noticeDetail?noticeNo=${vo.noticeNo}">${vo.noticeTitle}</a>
															<img src="resources/img/board/new-icon.PNG">
														</td>
													</c:when>
													<c:otherwise>
														<td><a href="noticeDetail?noticeNo=${vo.noticeNo}">${vo.noticeTitle}</a></td>
													</c:otherwise>
												</c:choose>
												<td>${vo.noticeDate}</td>
												<td>${vo.noticeView}</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<th scope="row">${vo.noticeNo}</th>
												<c:choose>
													<c:when test="${vo.noticeDate eq sysdate}">
														<td><a href="noticeDetail?noticeNo=${vo.noticeNo}">${vo.noticeTitle}</a>
															<img src="resources/img/board/new-icon.PNG">
														</td>
													</c:when>
													<c:otherwise>
														<td><a href="noticeDetail?noticeNo=${vo.noticeNo}">${vo.noticeTitle}</a></td>
													</c:otherwise>
												</c:choose>
												<td>${vo.noticeDate}</td>
												<td>${vo.noticeView}</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			
			<div class="row" style="padding: 2% 0;"></div>
			
			<div class="row">
				<div class="input-group mb-3 mx-auto" style="width: 50%;">
				<!--
					<div class="input-group-prepend">
						<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">분류</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#" id="">제목</a>
							<a class="dropdown-item" href="#" id="">내용</a>
						</div>
					</div>
				 -->
					<div>
						<select class="input-group-prepend" name="searchCondition">
							<option value="분류" selected="selected">분류</option>
							<option value="제목">제목</option>
							<option value="내용">내용</option>
						</select>
					</div>
					<input type="text" class="form-control" id="searchContent"
						placeholder="검색할 내용을 입력하세요" aria-label="Text input with dropdown button">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" id="searchBtn" onclick="search()">search</button>
					</div>
				</div>
			</div>
			
			<nav class="blog-pagination justify-content-center d-flex" style="padding: 2.5% 0 ;">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li class="page-item">
							<a href="notice${pageMaker.makeQuery(pageMaker.startPage -1 )}" class="page-link">이전</a>
						</li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						<li class="page-item">
							<a href="notice${pageMaker.makeQuery(idx)}" class="page-link">${idx}</a>
						</li>
					</c:forEach>
					<c:if test="${pageMaker.next && pageMaker.endPage gt 0}">
						<li class="page-item">
							<a href="notice${pageMaker.makeQuery(pageMaker.endPage +1 )}" class="page-link">다음</a>
						</li>
					</c:if>
				</ul>
			</nav>
	      
			<div class="col-md-12 text-right">
				<button type="button" class="btn primary-btn" onclick ="location.href='noticeWriteForm'">글쓰기 </button>
			</div>
		</div>
	</form>
  </section>
  <!--================Contact Area =================-->

  <!--================ start footer Area  =================-->
  <jsp:include page="../common/footer.jsp" />
  <!--================ End footer Area  =================-->

  <!--================Contact Success and Error message Area =================-->
  <div id="success" class="modal modal-message fade" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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