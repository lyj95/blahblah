<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="icon" href="resources/img/favicon.png" type="image/png" />
<title>사전</title>
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
<style>
textarea.autosize {
	min-height: 50px;
}
</style>
<script type="text/javascript" src ="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function searchFunction() {
		var text = $('#txt').val();
		$('#res').text('');
		$.ajax({
			type : "POST",
			url : "search",
			data : {
				text : text
			},
			success : function(result) {
				if(result == null || result=="") {
					$('#res').append("<br>찾으시는 단어의 검색 결과가 없습니다.");
				} else{
					/* $('#res').val(''); */
					$('#res').append("<br><h5>"+text+"</h5>")
					$('#res').append(result).append("<br><br>"+"[출처] naver.com");
				}
			}
		});
	}
</script>

</head>
<body>
	<div style="margin:5%">
	<h4 style="color:gray">단어 찾기</h4>
	<input type="text" id="txt" style="border-color:rgba(3,207,93);">
	<a onclick="searchFunction();"><img src="resources/img/search.png" style="width:35px; height:32px"></a>
<!-- 	<input type="button" class="btn_search" value="검색" onclick="searchFunction();"> -->

	<div id="res"></div>
	</div>
</body>
</html>