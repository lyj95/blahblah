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
  <title>QnA</title>
  
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="resources/css/bootstrap.css" />
  <link rel="stylesheet" href="resources/css/flaticon.css" />
  <link rel="stylesheet" href="resources/css/themify-icons.css" />
  <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
  <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
  
  <!-- main css -->
  <link rel="stylesheet" href="resources/css/style.css" />
</head>

<%String userID = (String)request.getParameter("userID");%>

<script type="text/javascript">
function search() {
	
	if (document.getElementById("searchCondition").options[document.getElementById("searchCondition").selectedIndex].text=="제목") {
		if (!document.getElementById("searchContent").value) {
			alert("검색어를 입력하세요");
			document.form.action="qna";
		} else {
			document.form.action="searchByQnaTitle?searchContent="+encodeURI(document.getElementById('searchContent').value);
			document.form.submit();	
		}
	} else if (document.getElementById("searchCondition").options[document.getElementById("searchCondition").selectedIndex].text=="내용") {
		if (!document.getElementById("searchContent").value) {
			alert("검색어를 입력하세요");
			document.form.action="qna";
		} else {
			document.form.action="searchByQnaContent?searchContent="+encodeURI(document.getElementById('searchContent').value);
			document.form.submit();
		}
	} else {
		alert("검색 분류를 선택하세요");
		document.form.action="qna";
	}
}

/*
function qnaPwCheck(qnaNo, memberId) {
	
	alert(qnaNo);
	alert(memberId);
	
	if (memberId==userID) {
		alert("작성자");
		//location.href="qnaDetail?qnaNo="+qnaNoV;
	} else {
		alert("작성자만 열람이 가능합니다.");
		//location.href="qna";
	}
}
*/
</script>

<body>
  <!--================ Start Header Menu Area =================-->
  <jsp:include page="../common/menu-header.jsp" />
  <!--================ End Header Menu Area =================-->

  <!--================Home Banner Area : 아래부분은 수정한 부분입니다=================-->
  <section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6">
            <div class="banner_content text-center">
              <h2>QnA</h2>
              <div class="page_link">
                <p>QnA</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================End Home Banner Area =================-->

  <!--================Contact Area : 아래부분은 수정한 부분입니다=================-->

	<section class="contact_area section_gap" style="padding: 5% 0;">
			<div class="container">
				<div class="row">
				
					<div class="row" style="padding: 3% 0;"></div>
				
					<table class="table" style="text-align: center;">
						<thead>
							<tr>
								<th scope="col-md-1">글번호</th>
								<th scope="col-md-4">제목</th>
								<th scope="col-md-2">작성일</th>
								<th scope="col-md-1">작성자</th>
								<th scope="col-md-1">답변여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty qnaList}">
									<tr>
										<td colspan="4" align="center">------------------------- 작성된 글이 없습니다 -------------------------</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${qnaList}" var="vo">
										<tr>
											<th scope="row" >${vo.qnaNo}</th>
											<c:choose>
												<c:when test="${vo.qnaOpen eq 'N'}">
													<c:choose>
														<c:when test="${vo.qnaDate eq sysdate}">
															<td><img src="resources/img/board/lock.PNG">
																<a id="qnaPwCheckBtn"
																	href="openLockedQnaDetail?qnaNo=${vo.qnaNo}">${vo.qnaTitle}</a>
																<img src="resources/img/board/new-icon.PNG">
															</td>
														</c:when>
														<c:otherwise>
															<td><a href="qnaDetail?qnaNo=${vo.qnaNo}">${vo.qnaTitle}</a></td>
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${vo.qnaDate eq sysdate}">
															<td><a href="qnaDetail?qnaNo=${vo.qnaNo}">${vo.qnaTitle}</a>
																<img src="resources/img/board/new-icon.PNG"></td>
														</c:when>
														<c:otherwise>
															<td><a href="qnaDetail?qnaNo=${vo.qnaNo}">${vo.qnaTitle}</a></td>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
											<td>${vo.qnaDate}</td>
											<td>${vo.memberId}</td>
											<c:choose>
												<c:when test="${vo.qnaRep eq 'Y'}">
													<td><span class="badge badge-info">답변완료</span></td>
												</c:when>
												<c:otherwise>
													<td><span class="badge badge-light">답변대기</span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						<tbody>
					</table>
				</div>

				<div class="row" style="padding: 2% 0;"></div>
				
				<form name="form" method="post" action="searchByTitle" onsubmit="search()">
				<div class="row">
				<div class="input-group mb-3 mx-auto" style="width: 50%;">
					<div>
						<select class="input-group-prepend" name="searchCondition" id="searchCondition">
							<option value="분류" selected="selected">분류</option>
							<option value="제목">제목</option>
							<option value="내용">내용</option>
						</select>
					</div>
					<input type="text" class="form-control" id="searchContent" name="searchContent"
						placeholder="검색할 내용을 입력하세요" aria-label="Text input with dropdown button">
					<div class="input-group-append">
						<input type="submit" class="btn btn-outline-secondary" id="searchBtn" value="submit">
					</div>
				</div>
				</div>
				</form>

				<nav class="blog-pagination justify-content-center d-flex" style="padding: 2.5% 0 ;">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="page-item">
								<a href="qna${pageMaker.makeQuery(pageMaker.startPage -1 )}" class="page-link" aria-label="Previous">
									<span aria-hidden="true"><i class="ti-angle-left"></i></span></a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
							<c:if test="${idx>0}">
								<li class="page-item">
									<a href="qna${pageMaker.makeQuery(idx)}" class="page-link">${idx}</a>
								</li>
							</c:if>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage gt 0}">
							<li class="page-item">
								<a href="qna${pageMaker.makeQuery(pageMaker.endPage +1 )}" class="page-link" aria-label="Next">
									<span aria-hidden="true"> <i class="ti-angle-right"></i></span></a>
							</li>
						</c:if>
					</ul>
				</nav>
			
				<div class="col-md-12 text-right">
					<button class="btn primary-btn" onclick ="location.href='qnaWriteForm'">글쓰기</button>
				</div>
		</div>	
  </section>

  <!--================Contact Area =================-->

  <!--================ start footer Area  =================-->
  <jsp:include page="../common/footer.jsp" />
  <!--================ End footer Area  =================-->

  <!--================Contact Success and Error message Area =================-->
	<div id="qnaPwCheckForm" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>비밀번호</h2>
			<input type="password" name="qnaPw" id="qnaPw">
			<button class="btn primary-btn" id="qnaPwCheck" onclick ="qnaPwCheck()">확인6</button>
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