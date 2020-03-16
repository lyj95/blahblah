<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="icon" href="resources/img/favicon.png" type="image/png" />
    <title>내 강의실</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
    <style>
        textarea.autosize { min-height: 50px; }
        #endBtn {position: absolute; top: 30px; right: 50px;}
        .screenTxt {font-weight: bold; text-align: center; padding-top: 20%; font-size: larger;}
    </style>
  </head>

  <body>
    <script> 
    	// textarea 크기 자동 조절
        function resize(obj) {
          obj.style.height = "1px";
          obj.style.height = (12+obj.scrollHeight)+"px";
        }
    </script>  
    <script type="text/javascript">
    function dicFunction(){
		window.open('dictionary', '사전', 'top=150, left=1000, width=320px, height=250px, status=no, menubar=no, toolbar=no, resizable=no');
    }
    </script>

   <!--================ Start Header Menu Area =================-->
   <c:import url="../common/header.jsp"></c:import>
   <!-- style="background: #002347;" -->
  <!--================ End Header Menu Area =================-->

    <!--================ Start Course Details Area =================-->
    <section class="course_details_area section_gap">
    <div class="container">
            <h1 class="title">강의 보기</h1>
            <div class="row">
                <div class="col-lg-8 course_details_left">
	                <div id="screen" style="width: 100%; height:50%; border:1px solid lightgray; background:#f9f9f9;">
	                <c:choose>
		                <%-- <c:when test="${!empty lesson['classDay'] && lesson['flag'] eq true}"> --%>
		                <c:when test="${!empty lesson['attendChat'] && !empty lesson['write']}">
		                <p class="screenTxt">
		                		하단 버튼을 누르면 수업을 시작합니다<br><br>
		                	<a class="primary-btn" id="startBtn" href="javascript:void(0);" onclick="startChat();">강의 시작하기</a>
	                	</p>
			                <%-- <iframe src="https://localhost:8443/blahblah/chatting?userId=<%=session.getAttribute("userID")%>" style="width:100%; height:100%;"></iframe> --%>
		                </c:when>
		                <c:otherwise>
		                	<p class="screenTxt">
		                		수업 시간이 아닙니다. <br><br>다음 수업에서 만나요 :)
		                	</p>
		                </c:otherwise>
	                </c:choose>
	                </div>
                    <div class="content_wrapper">
						<h4 class="title">강의 피드백 
                        	<c:if test="${!empty lesson['write']}">
	                        	<span class="genric-btn primary small" style="float:right;" data-toggle="modal" data-target="#feedbackModal" data-backdrop="static">feedback 작성</span>
                        	</c:if>	
                       	</h4>
                        <div class="content">
                            <ul class="course_list">
                            	<c:if test="${empty feedback}">
                            		등록된 피드백이 없습니다
                            	</c:if>
                                <c:forEach items="${feedback}" var="feedback">
	                            	<li class="justify-content-between d-flex">
	                                    <p>
	                                    	${feedback.classDate} 수업의 피드백
	                                    	<c:if test="${userID eq lesson['TUTOR_ID']}">
		                                    	<span class="genric-btn primary small" style="float:right; margin: 0 15px; padding: 0 10px;" data-toggle="modal" data-backdrop="static" onclick='showFeedbackUpdate("${feedback.feedbackTxt}","${feedback.classDate}");'>수정</span>
          									</c:if>
	                                    </p>
	                                    <a class="primary-btn text-uppercase" data-toggle="modal" data-backdrop="static" href="javascript:void(0);" onclick="showFeedback('${feedback.feedbackTxt}');">View Details</a>
	                                </li>
                            	</c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>


                <div class="col-lg-4 right-contents">
                    <ul>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Course Name </p>
                                <span class="or">${lesson["LESSON_NAME"]}</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Trainer’s Name</p>
                                <span class="or">${lesson["TUTOR_ID"]}</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>Level </p>
                                <span class="genric-btn primary small">${lesson["LESSON_LEVEL"]}</span>
                            </a>
                        </li>
                    </ul>
                    <h4 class="title">Memo</h4>
                    <div class="feedeback">
                        <textarea name="memo" class="autosize" style="width: 100%;" onkeydown="resize(this)" onkeyup="resize(this)" placeholder=" 수업 내용 필기"></textarea>
                        <a href="#" class="primary-btn2 text-uppercase enroll rounded-0 text-white">Save Memo</a>
                    </div>
                   	<!-- 사전 추가 -->
					<h4 class="title">사전</h4>
					<a class="justify-content-between d-flex" onclick="dicFunction();">
                           <p>단어 찾기</p>
                           <p class="genric-btn primary small">dictionary</p>
                    </a>

                     <h4 class="title">진도율</h4>

                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-2" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0"
                             aria-valuemax="100"></div>
                        </div>
                    </div>
                    <h4 class="title">자료실</h4>
                    <ul>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>study.pptx</p>
                                <span class="genric-btn primary small">download</span>
                            </a>
                        </li>
                    </ul>
                    </div>
            </div>
        </div>
    </section>
    <!--================ End Course Details Area =================-->
   	<!-- 피드백 작성 모달 -->
	<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="feedbackModalLabel">${lesson['classDay']} ${lesson["MEMBER_ID"]} 수강생  수업 피드백 작성</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="insertFeedback">
				<div class="modal-body">
					<div class="form-group">
			            <label for="insert-fb-txt" class="col-form-label">feedback context</label>
			            <textarea class="form-control" id="insert-fb-txt" name="insert-fb-txt" required></textarea>
			        </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-warning" id="feedbackBtn" onclick="ajaxFeedback('insert');">피드백 저장</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 피드백 작성 모달 end-->
	<!-- 피드백 확인 모달 -->
	<div class="modal fade" id="feedbackDetail" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="feedbackModalLabel">${lesson['classDay']} ${lesson["MEMBER_ID"]} 수강생  수업 피드백 내용</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="insertFeedback">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-form-label" >피드백 내용</label>
			            <p id="feedbackContext"></p>
			        </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 피드백 확인 모달 end-->
	<!-- 피드백 수정 모달 -->
	<div class="modal fade" id="feedbackUpdate" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="feedbackModalLabel">${lesson['classDay']} ${lesson["MEMBER_ID"]} 수강생  수업 피드백 내용 수정</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="insertFeedback">
				<div class="modal-body">
					<div class="form-group">
						<input type="hidden" id="fd-date">
			            <label for="insert-fb-txt" class="col-form-label">수정할 내용</label>
			            <textarea class="form-control" id="update-fb-txt" name="update-fb-txt" required></textarea>
			        </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-warning" id="updateFbBtn" onclick="ajaxFeedback('update');">피드백 수정</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 피드백 수정 모달 end-->
    <!--================ Start footer Area  =================-->
    <jsp:include page="../common/footer.jsp" />
          <!--================ End footer Area  =================-->
      
          <!-- Optional JavaScript -->
          <!-- jQuery first, then Popper.js, then Bootstrap JS -->
          <script src="resources/js/jquery-3.2.1.min.js"></script>
          <script src="resources/js/popper.js"></script>
          <script src="resources/js/bootstrap.min.js"></script>
          <script src="resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
          <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
          <script src="resources/js/owl-carousel-thumb.min.js"></script>
          <script src="resources/js/jquery.ajaxchimp.min.js"></script>
          <script src="resources/js/mail-script.js"></script>
          <!--gmaps Js-->
          <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
          <script src="resources/js/gmaps.min.js"></script>
          <script src="resources/js/theme.js"></script>
          <script type="text/javascript">
	          	function ajaxFeedback(status){
	        		var feedbackTxt;
	        		var classDate;
	        		var url;
	        		if(status == "insert"){
	        			url = "insertFeedback";
		          		feedbackTxt = $("#insert-fb-txt").val();
		          		classDate = '${lesson["classDay"]}';
		          		if($('#insert-fb-txt').val() == "" || $('#insert-fb-txt').val().length<10){
	         			  alert("피드백을 10자 이상 입력해주세요");
	         			  return false;
	         		  	}
	        		} 
	        		if(status == "update"){
	        			url = "updateFeedback";
	        			feedbackTxt = $("#update-fb-txt").val();
	        			classDate = $("#fd-date").val();
		          		if($('#update-fb-txt').val() == "" || $('#update-fb-txt').val().length<10){
	         			  alert("피드백을 10자 이상 입력해주세요");
	         			  return false;
	         		  	}
	        		}
		          	  $.ajax({
		          		  url:url,
		          		  data: {	lessonNo : '${lesson["LESSON_NO"]}',
		          			  		memberId : '${lesson["MEMBER_ID"]}',	// 공통값
		          			  		feedbackTxt : feedbackTxt,
		          			  		classDate : classDate
		          			  	},
		          		  async: false,
		          		  type:"POST",
		          		  dataType:"text",
		          		  success:function(data){
		          			  alert(data);
		          			  console.log(data);
		          			  location.reload()
		          		  },
		          		  error:function(request,status,error){
		          		   	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		          		  }
		          	  });
	        	}
				// feedback 확인
				function showFeedback(txt){
					$("#feedbackContext").text(txt);
					$('#feedbackDetail').modal('show');
				}
				function showFeedbackUpdate(txt,date){
					$("#update-fb-txt").text(txt);
					$("#fd-date").val(date);
					$('#feedbackUpdate').modal('show');
				}
				function startChat(){
					$('#screen').children().remove();
					 $("#screen").append("<iframe src='https://localhost:8443/blahblah/chatting?userId=<%=session.getAttribute("userID")%>' style='width:100%; height:100%;'></iframe>");
					 $("#screen").append('<a class="primary-btn" id="endBtn" href="javascript:void(0);" onclick="endChat();">강의 종료</a>');
					
				}
				function endChat(){
					$('iframe').remove();
					$('#endBtn').remove();
					if("${userID}"=="${lesson['TUTOR_ID']}"){
						$('#screen').append('<p class="screenTxt"> ${userID} 강사님 <br><br>오늘 수업의 피드백을 작성을 해주세요 <br><br> <small>※피드백 미작성시 수업 완료 처리가 되지 않습니다!</small></p>');
					} else{
						$('#screen').append('<p class="screenTxt"> 오늘 ${userID}님의 수업은 여기까지!<br><br> 다음 수업에서 만나요 ~ </p>');
					}
				}
				
          </script>
        </body>
</html>