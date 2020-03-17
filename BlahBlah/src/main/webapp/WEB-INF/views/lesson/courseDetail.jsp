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
    <link rel="icon" href="img/favicon.png" type="image/png" />
    <title>Courses Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  </head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js" ></script>
<script type="text/javascript">
		function chkTable(){
		var lessonNo = ${vo.lessonNo};
		var jdata = { "lessonNo" : lessonNo };
		
		<% String memberType = (String)session.getAttribute("memberType");
			System.out.println(memberType);
		%>
		var memberType = "<%=memberType%>";
			
			if(memberType == "TUTOR") {
				alert("강사계정은 수강신청을 할 수 없습니다.");
			} else {
				$.ajax({
					url: "/blahblah/chkTable", 
			        type: "POST",
			        dataType: "json",
			        contentType:"application/json",
			        data: JSON.stringify(jdata),
					success:function(msg){			//통신 성공시
						if(msg.res == true){		//결제 진행 가능
							location.href='/blahblah/payment?lessonNo=${vo.lessonNo}';
						} else {					//결제 진행 불가
							alert("이미 수강 중이거나 신청 마감된 강의입니다.");
						}
					},
					
					error:function(request,status,error){
				        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
				        location.href='courseDetail?lessonNo=${vo.lessonNo}';  
					}
				});
			}
	};
</script> 
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
                <h2 style="font-size:250%">${vo.lessonName}</h2>
                <div class="page_link">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================ Start Course Details Area =================-->
    <section class="course_details_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 course_details_left">
  
                    <div class="content_wrapper">
                    	<div class="main_image">
                        <img class="img-fluid" src="resources/img/courses/course-details.jpg" alt="">
                   		</div>
                   		
                        <h4 class="title">강의 소개</h4>
                        <div class="content">
                       		 ${vo.lessonInfo}

                        </div>
                        
                        <h4 class="title">샘플 강의</h4>
                        <div class="content">
							<video oncontextmenu="return false;" id="myVideo" width="640"controls>
								<source src="resources/lessonSample/${vo.lessonNo}/videoFile.mp4">
							</video>                
                        </div>                       
                    </div>
                </div>


                <div class="col-lg-4 right-contents" >
                        <h3><span class="badge" style="background:#f8b600;">${vo.lessonType}</span>
						<span class="badge" style="background:#f8b600;">${vo.lessonLevel}</span></h3>
                    <ul>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>강사명</p>
                                <span class="or">${vo.tutorId}</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>수강료 </p>
                                <span> ${vo.lessonPrice}</span>
                            </a>
                        </li>
                        <li>
                            <a class="justify-content-between d-flex" href="#">
                                <p>수업 시간 </p>
                                <span>${vo.lessonTime}</span>
                            </a>
                        </li>
                    </ul>
                    <div class="row">
                    	<div class="col-6">
                   			<input type="button" onclick="chkTable()" class="primary-btn2 text-uppercase enroll rounded-0 text-white" value="수강 신청"/>
                    	</div>
                    	  
						<!-- 찜 버튼 -->    
                    	<div class="col-6">
                    		<c:choose>
                    			<c:when test="${fav eq 'fav' }">
                    				<button type="button" onclick="addFav()" class="primary-btn2 text-uppercase enroll rounded-0 text-white" ><i id="heart" class="ti-heart mr-2" style="color:#fdc632;"></i><span>찜</span></button>
                    			</c:when>
                    			<c:otherwise>
                    				<button type="button" onclick="addFav()" class="primary-btn2 text-uppercase enroll rounded-0 text-white" ><i id="heart" class="ti-heart mr-2"></i><span>찜</span></button>
                    			</c:otherwise>
                    		</c:choose>
                    	</div>		
                    </div>

                    <h4 class="title">후기 작성</h4>
                    <div class="content">
                        
                        <!-- 수강후기 작성 폼-->
                        <div class="feedeback">
                        				 
                           <form id="reviewForm" name="reviewForm" method="post"></form>
                              <div class="d-flex flex-row reviews justify-content-between">
                              <input type="hidden" name="lessonVo" value="${vo.lessonNo}"> <!--강의번호  -->
                              <input type="hidden" name="memberId" value="${vo.tutorId}"> <!-- 세션에 있는  아이디 갖고오는걸로 수정  -->
								<!-- 평점 선택창 -->
								<span>평점</span>
								<div class="default-select" id="reviewGrade">
									<select style="display: none;">
										<option value="1">☆</option>
										<option value="2">☆☆</option>
										<option value="3">☆☆☆</option>
										<option value="4">☆☆☆☆</option>
										<option value="5">☆☆☆☆☆</option>
									</select>
								</div>
							</div>
                            <textarea name="reviewContent" id="reviewContent" class="form-control" cols="10" rows="10"></textarea>
                            <div class="mt-10 text-right">
                                <a href="javascript:reviewsubmit();" class="primary-btn2 text-right rounded-0 text-white">작성</a>
                            </div>
                        </div>
                        <!-- 수강후기 작성 폼 완료-->
                        
                        
                        <!-- 수강후기 평균 별점 -->
                        <h4 class="title">수강 후기</h4>
                        <div class="review-top row pt-40">
                            <div class="col-lg-12">
                                <div class="d-flex flex-row reviews justify-content-between">
                                <div id="reviewAvg"></div>                          
                                </div>
                            </div>
                        </div>
                   <!-- 수강후기 평균 별점 종료 -->
                         
  				<!-- ------------- 강의리뷰 반복되는 부분 ------------ -->
						<div class="comments-area mb-30">
							<div id="reviewList"></div>
						</div>

  				<!-- ------------- 강의리뷰 반복되는 부분 종료 ------------ -->				
						<a href="courseList"
								class="primary-btn2 text-uppercase enroll rounded-0 text-white">강의목록</a>
						<div class="row" style="padding: 2.5%;"></div>
						<c:if test="${userID eq vo.tutorId}">
							<div class="row">
								<div class="col">
									<button type="button" class="genric-btn info "style="width: 45%;"
										onclick="location.href='updateCourseForm?lessonNo=${vo.lessonNo}'">수정</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="button" class="genric-btn info " style="width: 45%;"
										onclick="location.href='deleteCourse?lessonNo=${vo.lessonNo}'">삭제</button>
								</div>
							</div>
						</c:if>
						</div>
					</div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Course Details Area =================-->

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
<script>
$(function(){
    
    getCommentList(); //처음 로딩시 목록 가져오기
  	getCommentAvg();
    
});
 
function reviewsubmit(){
	
	 var reviewContent = $("#reviewContent").val(); //댓글의 내용
     var lessonNo = "${vo.lessonNo}"; //강의번호
     var memberId = "${userID}";
     var memberPhoto = "${memberPhoto}";
     var reviewGrade = $("#reviewGrade option:selected").val();
     var params = {
    		 "reviewContent" : reviewContent, 
    		 "lessonNo" : lessonNo, 
    		 "memberId" : memberId, 
    		 "reviewGrade" : reviewGrade,
    		 "memberPhoto" : memberPhoto
    		 };    
     
     $.ajax({
         type: "post", //데이터를 보낼 방식
         url: "addReview", //데이터를 보낼 url
         data: params, //보낼 데이터
          
         success: function(data){//데이터를 보내는 것이 성공했을 시 출력되는 메시지
             
	            if(data.check==true){
		            alert("리뷰가 등록되었습니다.");
	                $("#reviewContent").val("");//comment 창 초기화
	                getCommentList(); //댓글목록 불러오기
	                getCommentAvg();
	            }
	        },
    	error:function(){
    		 alert("서버와 통신실패");
         	// alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    }
 });
}

function getCommentList(){

	$.ajax({
	        type:'GET',
	        url : "reviewList?lessonNo=${vo.lessonNo}",  //보낼 url
	        dataType : "json",
	        success : function(data){
	        	var res = data.reviewlist;
	        	var memberId = "${userID}";
	            var html = "";
	            $.each(res, function(i){ 
	            		/* console.log("//ajax data:"+res[i].memberId);
	            		console.log("//ajax data:"+res[i].reviewDate);
	            		console.log("//ajax data:"+res[i].reviewContent);
	            		console.log("//:"+res[i].memberPhoto); */
	            	
	                    html += "<div class='comment-list'>";
	                    html += "<div class='single-comment single-reviews justify-content-between d-flex'>";
	                    html += "<div class='user justify-content-between d-flex'><div class='thumb'>";
	                    html += "<img id ='profileImg"+i+"' src='resources/profile/"+res[i].memberPhoto+"' onerror='no_image("+i+");' style='width: 5vw; height: 60px;' /></div><div class='desc'>";  //1.프로필사진 링크 넣기
	                    html += "<h5><a href='#'>"+res[i].memberId+"</a>";  //2.작성자 아이디
	                    html += "<div class='star'>";//별점부분

						var grade=res[i].reviewGrade;

		                for(var star=1; star<6; star++){
		                	if(grade<star){
		                		html += "<span class='ti-star'></span>";
		                	}else{
		                		html += "<span class='ti-star checked'></span> ";
		                	}
		                } 
	                    html += "</div></h5>";	                
	                    html += "<p class='reviewDate'>"+res[i].reviewDate+"</p>";
	                    html += "<p class='reviewDate'>"+res[i].reviewContent+"&nbsp; &nbsp;";
	                    if(res[i].memberId == memberId){
	                    html += "<a href='deleteReview?reviewNo="+res[i].reviewNo+"&lessonNo="+res[i].lessonNo+"';'><img src='resources/img/delete.png' width='12%'alt=''></a>";
	                    }
	                    html += "</p></div></div></div></div>";
	            });
       
            	$("#reviewList").html(html); //페이지에 목록 출력      
        },
        
        error:function(request,status,error){
        	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
          

}
function getCommentAvg(){  

	$.ajax({
	        type:'GET',
	        url : "reviewAvg?lessonNo=${vo.lessonNo}",  //보낼 url
	        dataType : "json",
	        success : function(data){
	        	var avg = data.avg;
	            var html = "";

	            html += "<div class='row'>&nbsp; &nbsp;<h5>평균 평점 "+avg+"</h5>&nbsp;&nbsp;&nbsp;";	                   
	            html += "<div class='star'>";//별점부분
	            for(var star=1; star<6; star++){
		            	if(avg<star){
			                	html += "<i class='ti-star'></i>";
			             }else{
			            		html += "<i class='ti-star checked'></i>";
			              }
		             }                               
	                 html += "</div><div>";	                
            	$("#reviewAvg").html(html); //페이지에 목록 출력      

       
        },
        
        error:function(request,status,error){
        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });       
}  


function no_image(num) {
	/* $("img[name=profileImg]").attr("src", "resources/img/about.png").css('width: 5vw', 'height: auto'); */    // 주의 : 대체 이미지도 없으면 무한 루프에 걸린다.
	$("#profileImg"+num).attr("src", "resources/img/about.png").css('width: 5vw', 'height: auto');  
} 


</script>
<!-- 찜 관련 자바스크립트 -->
<script type="text/javascript">
function addFav(){
	var userId = "${userID}";
	if(userId == null){
		if(confirm("'찜'은 로그인 후 사용 가능합니다. \n지금 로그인 하시겠습니까?")){
			location.href="/login";
		}
	}else{
		$.ajax({
	       type:'POST',
	       url : "addFav?lessonNo=${vo.lessonNo}&memberId=${userID}", 
	       dataType : "json",
	       success : function(result){
			if(result == "0" ){
	       		$("#heart").css("color","white"); 
			}else{
	       		$("#heart").css("color","#fdc632"); 
			}               
	       },
	   		error:function(request,status,error){
	   			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	  		}
		});       
	}

}
</script>


</body>
</html>