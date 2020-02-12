<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="icon" href="resources/img/favicon.png" type="image/png" />
  <title>Q&A</title>
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

  <!--================Home Banner Area : 아래부분은 수정한 부분입니다=================-->
  <section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6">
            <div class="banner_content text-center">
              <h2>Q&A</h2>
              <div class="page_link">
                <p>질문게시판</p>
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
        



        <table class="table" style="text-align: center;">
          <thead>
            <tr>
              <th scope="col-md-1">글번호</th>
              <th scope="col-md-4">제목</th>
              <th scope="col-md-2">작성일</th>
              <th scope="col-md-1">작성자</th>
              <th scope="col-md-1">조회수</th>
              <th scope="col-md-1">답변여부</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row" >1</th>
              <td >영어 강사로 지원하고 싶습니다.</td>
              <td>2020-02-01</td>
              <td>@mdo</td>
              <td>21</td>           
              <td> <span class="badge badge-light" >답변대기</span></td>
            </tr>
            <tr>
              <th scope="row" >2</th>
              <td><a href="QnADetail.jsp">강의를 연장하려면 어떻게 해야하나요?</a></td>
              <td>2020-01-31</td>
              <td>@fat</td>
              <td>55</td>
              <td><span class="badge badge-info" >답변완료</span></td>
            </tr>
            <tr>
              <th scope="row" >3</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>12</td>
              <td><span class="badge badge-info" >답변완료</span></td>
            </tr>
            <tr>
              <th scope="row" >4</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>70</td>
              <td><span class="badge badge-light" >답변대기</span></td>
            </tr>
            <tr>
              <th scope="row" >5</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>123</td>
              <td><span class="badge badge-light" >답변대기</span></td>
            </tr>
            <tr>
              <th scope="row" >6</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>19</td>
              <td><span class="badge badge-light" >답변대기</span></td>
            </tr>
            <tr>
              <th scope="row" >7</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>81</td>
              <td><span class="badge badge-info" >답변완료</span></td>
            </tr>
            <tr>
              <th scope="row" >8</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>40</td>
              <td><span class="badge badge-light" >답변대기</span></td>
            </tr>
            <tr>
              <th scope="row" >9</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>33</td>
              <td><span class="badge badge-info" >답변완료</span></td>
            </tr>
            <tr>
              <th scope="row" >10</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
              <td>22</td>
              <td><span class="badge badge-light" >답변대기</span></td>
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
        <button type="submit" value="submit" onclick ="location.href='QnAWriting.jsp'" class="btn primary-btn">
      		    글쓰기
        </button>
      </div>
      </form>
    </div>
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