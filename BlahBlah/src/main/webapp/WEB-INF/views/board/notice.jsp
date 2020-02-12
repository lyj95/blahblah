<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="container">
      <div class="row">
        <table class="table"style="text-align:center;">
          <thead>
            <tr>
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성일</th>
              <th scope="col">조회수</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>홈페이지 점검 및 개편관련 안내 공지사항입니다.</td>
              <td>2020-02-03</td>
              <td>305</td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td><a href="board/noticeDetail.jsp">[올인원] 회화패키지 - 상세 강의 명칭 변경 안내</a></td>
              <td>2020-01-31</td>
              <td>288</td>
            </tr>
            <tr>
              <th scope="row">3</th>
              <td>2월 친구 초대 이벤트 안내 공지사항 입니다.</td>
              <td>2020-01-30</td>
              <td>175</td>
            </tr>
            <tr>
              <th scope="row">4</th>
              <td>설 연휴 강의 시스템 점검 안내</td>
              <td>2020-01-25</td>
              <td>88</td>
            </tr>
            <tr>
              <th scope="row">5</th>
              <td><a href="board/noticeDetail.jsp">블라블라 신규 회원 도서 증정 이벤트</a></td>
              <td>2020-01-08</td>
              <td>250</td>
            </tr>
            <tr>
              <th scope="row">6</th>
              <td>새해 맞이 특별 이벤트 안내</td>
              <td>2019-12-31</td>
              <td>123</td>
            </tr>
            <tr>
              <th scope="row">7</th>
              <td>마이페이지 관련 공지사항</td>
              <td>2019-12-31</td>
              <td>123</td>
            </tr>
            <tr>
              <th scope="row">8</th>
              <td>홈페이지 점검 및 개편관련 안내</td>
              <td>2019-12-31</td>
              <td>123</td>
            </tr>
            <tr>
              <th scope="row">9</th>
              <td>마이페이지 관련 공지사항</td>
              <td>2019-12-31</td>
              <td>123</td>
            </tr>
            <tr>
              <th scope="row">10</th>
              <td>홈페이지 점검 및 개편관련 안내</td>
              <td>2019-12-31</td>
              <td>123</td>
            </tr>
          </tbody>
        </table>
        </div>
      <div class="row" style="padding: 2% 0;"></div>
      <div class="row">
        <div class="input-group mb-3 mx-auto" style="width: 50%;">
          <div class="input-group-prepend">
            <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">분류</button>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="#">제목</a>
              <a class="dropdown-item" href="#">내용</a>
            </div>
          </div>
          <input type="text" class="form-control" placeholder="검색할 내용을 입력하세요"
            aria-label="Text input with dropdown button">
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2">search</button>
          </div>
        </div>
      </div>

      <nav class="blog-pagination justify-content-center d-flex" style="padding: 2.5% 0 ;">
        <ul class="pagination">
          <li class="page-item">
            <a href="#" class="page-link" aria-label="Previous">
              <span aria-hidden="true">
                <i class="ti-angle-left"></i>
              </span>
            </a>
          </li>
          <li class="page-item"><a href="#" class="page-link">01</a></li>
          <li class="page-item "><a href="#" class="page-link">02</a></li>
          <li class="page-item"><a href="#" class="page-link">03</a></li>
          <li class="page-item"><a href="#" class="page-link">04</a></li>
          <li class="page-item"><a href="#" class="page-link">05</a></li>
          <li class="page-item">
            <a href="#" class="page-link" aria-label="Next">
              <span aria-hidden="true">
                <i class="ti-angle-right"></i>
              </span>
            </a>
          </li>
        </ul>
      </nav>
      <div class="col-md-12 text-right">
        <button type="button" value="write" onclick ="location.href='noticeWriting.jsp'" class="btn primary-btn">글쓰기 </button>
      </div>
    </div>
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