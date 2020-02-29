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

    <!--================Contact Area =================-->
	<section class="contact_area section_gap" style="padding: 6% 0 10% 0;">
		<div class="container">
			<form class="needs-validation" method="post" action="insertQna" onsubmit="submitContents()" id="form">
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="validationCustom01">제목</label>
						<input type="text" class="form-control" name="qnaTitle" placeholder="제목을 입력하세요" required>             
					</div>
				</div>    
				<div class="mb-10">
					<label for="validationTextarea">내용</label>
					<textarea cols="15" rows="15" class="form-control" name="qnaContent" id="ir1"
						style="resize: none; margin: 0 0 2% 0 ;" placeholder="내용을 입력하세요" required></textarea>
            	</div>
				<div class="form-group row">
					<div class="col-sm-2">비밀글 여부</div>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" id="qnaOpen" name="qnaOpen" value="N">
							<label class="form-check-label" for="gridCheck1">
								비밀글을 작성하시려면 체크해주세요. 작성자만 게시글을 열람할 수 있습니다.
							</label>
						</div>
					</div>
				</div>
				<input type="button" class="btn primary-btn" 
					style="float:right; margin-left:3%;" value="취소" onclick="location.href='qna'">
				<input type="submit" class="btn primary-btn" id="submit" style="float:right;" value="작성 완료">
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
