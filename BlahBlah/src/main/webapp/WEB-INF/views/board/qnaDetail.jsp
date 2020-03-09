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
    <title>QnA</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
    
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<%String userID = (String)request.getParameter("userID");%>
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

    <!--================Contact Area: 아래부분은 수정한 부분입니다 =================-->
    <section class="contact_area section_gap" style="padding: 6% 10% 10% 10%;">
    	<div class="container">
		   	<form method="post" action="qnaUpdateForm">
		   		<input type="hidden" name="qnaNo" value="${vo.qnaNo}">
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
											<td colspan="3" class="t_al2"> &nbsp;<b>${vo.qnaTitle}</b></td>
										</tr>
										<tr>
											<td class="t_bc2 t_b0" style="background: #f1f4f7;font-weight: bold; font-size: 14px;
												text-align: center; padding: 1%; ">작성일</td>
											<td class="t_al2 t_b0">&nbsp; ${vo.qnaDate}</td>
										</tr>
									</tbody>
								</table>
								
								<p class="t_inf"></p>
								
								<div class="text_area" style="padding: 2% 2% 10% 2%;">
									<!-- 내용 출력 -->
									<div class="col"></div>
									<div class="content col-12">
										${vo.qnaContent}
										<div class="col"></div>
									</div>
								</div>
								<div class="br"></div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<c:if test="${userID eq vo.memberId}">
							<div class="col-10"></div>
							<input type="submit" value="수정" class="genric-btn info circle" style="float: right;">
							&nbsp;&nbsp;
							<button type="button" class="genric-btn info circle" style="float: right;"
								onclick="location.href='deleteQna?qnaNo=${vo.qnaNo}'">삭제</button>
						</c:if>
					</div>
					<br>
					<div class="row" id="idCheck">
						<div class="col-10"></div>
						<button type="button" class="genric-btn info circle" style="float: right;"
						onclick="location.href='qna'">목록으로</button>
					</div>
				</form>
				
			<div class="row"></div>	
				
			<div class="single-sidebar-widget newsletter_widget">
				<div class="comments-area" style="">
				<h3>답변</h3>
						<c:choose>
							<c:when test="${vo.qnaRep eq 'N'}">
								<c:choose>
									<c:when test="${memberType eq 'ADMIN'}">
										<form method="post" action="insertReply" id="form">
											<input type="hidden" name="qnaNo" value="${vo.qnaNo}">
											<textarea name="replyContent" id="ir1"
												placeholder="내용을 입력하세요" style="width:40%; height:30%;" required></textarea>
											<br>
											<input type="submit" id="submit" value="답글 등록" class="genric-btn info circle" style="float: right;">
										</form>
									</c:when>
									<c:otherwise>
										<p>
											답변이 없습니다
										</p>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${memberType eq 'ADMIN'}">
										<form method="post" action="updateReply" id="form">
											<input type="hidden" name="qnaNo" value="${vo.qnaNo}">
											<textarea name="replyContent" id="ir1"
												placeholder="내용을 입력하세요" style="width:40%; height:30%;"
												required>${reply.replyContent}</textarea>
											<br>
											<input type="button" class="genric-btn info circle" 
												style="float:right; margin-left:3%;" value="취소" onclick="location.href='qnaDetail?qnaNo=${vo.qnaNo}'">
											<input type="submit" id="submit" value="답글 수정" class="genric-btn info circle" style="float: right;">
										</form>
									</c:when>
									<c:otherwise>
										<p>
											${reply.replyContent}
										</p>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
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
    <!-- 스마트 에디터 -->
    <script type="text/javascript" src="resources/smartEditor/js/service/HuskyEZCreator.js" charset="UTF-8"></script>
  </body>
  
    <script type="text/javascript">
   		var oEditors = [];
   		$(function(){
   		      nhn.husky.EZCreator.createInIFrame({
   		          oAppRef: oEditors,
   		          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
   		          //SmartEditor2Skin.html 파일이 존재하는 경로
   		          sSkinURI: "resources/smartEditor/SmartEditor2Skin.html",  
   		          htParams : {
   		              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
   		              bUseToolbar : true,             
   		              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
   		              bUseVerticalResizer : true,     
   		              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
   		              bUseModeChanger : true,         
   		              fOnBeforeUnload : function(){
   		                   
   		              }
   		          }, 
   		          fOnAppLoad : function(){
   		              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
   		              //oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
   		          },
   		          fCreator: "createSEditor2"
   		      });
   		      
   		      //저장버튼 클릭시 form 전송
   		      $("#submit").click(function(){
   		          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
   		          $("#form").submit();
   		      });    
   		});
    </script>
</html>
