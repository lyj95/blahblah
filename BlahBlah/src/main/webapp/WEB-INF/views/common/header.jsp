<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.blah.vo.MemberVo" %>
<% MemberVo acc = (MemberVo)session.getAttribute("vo"); %> 

    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="resources/img/favicon.png" type="image/png" />
    <title>Blah Blah</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/flaticon.css" />
    <link rel="stylesheet" href="resources/css/themify-icons.css" />
    <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css" />
    <!-- main css -->
    <link rel="stylesheet" href="resources/css/style.css" />

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
   function getUnread(){
      $.ajax({
         type : "POST",
         url : "msgUnread?memberId=${userID}",
         dataType : "json",
         success : function(result){
            if(result >= 1){   //결과값이 1보다 크면 결과 출력
               showUnread(result);
            } else{
               showUnread('');
            }
         }
      });
   }
/*    function getInfiniteUnread(){
      setInterval(function(){
         getUnread();
      }, 10000);
   } */
   function showUnread(result){
      $('#unread').html(result);
   }
   
</script>

<!--================ Start Header Menu Area =================-->
    <header class="header_area">
      <div class="main_menu">
        <div class="search_input" id="search_input_box">
          <div class="container">
            <form class="d-flex justify-content-between" id="searchform" action="SearchKeywordCourse">
              <input
                type="text"
                class="form-control"
                id="keyword" name="keyword"
                placeholder="검색어를 입력하세요"
              />
              <button type="submit" class="btn"></button>
              <span
                class="ti-close"
                id="close_search"
                title="Close Search"
              ></span>
            </form>
          </div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-light">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <a class="navbar-brand logo_h" href="main"
              ><img src="resources/img/logo.png" alt=""
            /></a>
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="icon-bar"></span> <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div
              class="collapse navbar-collapse offset"
              id="navbarSupportedContent"
            >
              <ul class="nav navbar-nav menu_nav ml-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="main">Home</a>
                </li>
                
                <%
                
                	if(request.getSession().getAttribute("login") != null) { 
                	String memberType = (String)request.getSession().getAttribute("memberType");
	                  	if(memberType.equals("USER")) { 
            	%>
                <li class="nav-item">
                  <a class="nav-link" href="leveltestStart">Level Test</a>
                </li>
                <%
	                  	}
                	}else{  //로그인 안했을 경우
                %>
                <li class="nav-item">
                  <a class="nav-link" href="leveltestStart">Level Test</a>
                </li>
                <%
                	}
                %>
                <li class="nav-item">
                  <a class="nav-link" href="courseList?page=1&perPageNum=6">Course</a>
                </li>
                <li class="nav-item submenu dropdown">
                  <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    role="button"
                    aria-haspopup="true"
                    aria-expanded="false"
                    >Customer</a
                  >
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="notice">Notice</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="qna">QnA</a>
                    </li>
                  </ul>
                </li>                
                	<%
	                  	// 로그인 안되어있을 경우
	                  	if(request.getSession().getAttribute("login") == null ) { 
            		%>
            			<li class="nav-item">
            					<a class="nav-link" href="signupform">SignUp</a>
           				</li>
           				<li class="nav-item">
           					<a class="nav-link" href="login">Login</a>
           				</li>
                     <%
                        // 로그인 했을 경우
                        } else {
                     %>
           				<li class="nav-item">
           					<a class="nav-link" href="mypage">My Page</a>
           					<span class="badge badge-danger badge-counter" id="unread"></span>
           				</li>
           				<li class="nav-item">
           					<a class="nav-link" href="logout">Logout</a>
           				</li>
                     <%
                        }
                     %>
                <li class="nav-item">
                  <a href="#" class="nav-link search" id="search">
                    <i class="ti-search"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </header>
    
    <!-- ================================= 챗봇 ======================================= -->
    <div id="frogue-container" class="position-right-bottom"
      data-chatbot="2864ec5a-3099-4752-8fa4-45df068b6e4e"></div>
      
	<script>
	(function(d, s, id){
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) {return;}
	    js = d.createElement(s); js.id = id;
	    js.src = "https:\/\/danbee.ai/js/plugins/frogue-embed/frogue-embed.min.js";
	    fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'frogue-embed'));
	</script>
	<!-- ================================= 챗봇 ======================================= -->
	<script>
	$("#searchform").submit(function() {
		System.out.println("searchCheck() 함수 실행");
		if ($(this).children("input[name=keyword]").val().length < 1) {
			alert("검색어를 입력해주세요.");
			return false;
		}
		return true;
	});
	</script>
<!--================ End Header Menu Area =================-->
