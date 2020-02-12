<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!--================Home Banner Area : 이 아래부분은 수정한 부분입니다!=================-->
    <section class="banner_area">
      <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6">
              <div class="banner_content text-center">
                <h2>NOTICE</h2>
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

    <!--================Contact Area  : 이 아래부분은 수정한 부분입니다!=================-->
    <section class="contact_area section_gap" style="padding: 6% 0 10% 0;">
      <div class="container">
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
                    <td colspan="3" class="t_al2"> &nbsp;<b> [올인원] 회화패키지 - 상세 강의 명칭 변경 안내</b></td>
                  </tr>
                  <tr>
                    <td class="t_bc2 t_b0"
                      style="background: #f1f4f7;font-weight: bold; font-size: 14px; text-align: center;padding: 1%; ">등록일
                    </td>
                    <td class="t_al2 t_b0">&nbsp; 2020.01.30</td>
                    <td col-md-1 lg-1
                      style="background: #f1f4f7;font-weight: bold; font-size: 14px; text-align: center; padding: 1%;">조회수
                    </td>
                    <td col-md-1 lg-1 class="t_b0">&nbsp; 55</td>
                  </tr>
                </tbody>
              </table >
              <p class="t_inf"></p>
              <div class="text_area" style="padding: 2% 2% 10% 2%;">
    
                <!-- 내용 출력 -->
                <div class="col"></div>
                <div class="content col-12">
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                  incididunt ut labore et dolore
                  magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
                  ut aliquip ex ea commodo
                  consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum.
                  <br>
                  <br>
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                  incididunt ut labore et dolore
                  magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
                  ut aliquip ex ea
                  commodoconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                  cillum. Lorem ipsum dolor sit
                  amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                  dolore magna aliqua. Ut enim
                  ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                  commodo consequat. Duis aute
                  irure dolor in reprehenderit in voluptate velit esse cillum.
                  <div class="col"></div>
                </div>
              </div>
              <div class="br"></div>
    
    
              <table class="col-12" cellpadding="0" style="padding: 5%; ">
                <colgroup>
                  <col width="130">
                  <col width="600">
                </colgroup>
                <tbody>
                  <tr>
                    <td class="t_bc2">이전글</td>
                    <td class="t_al2"><span class="t_asl">이전글 없습니다.</span></td>
                  </tr>
                  <tr>
                    <td class="t_bc2 t_b0">다음글</td>
                    <td class="t_al2 t_b0"><span class="t_asl"><a
                          href="./board.php?bo_table=notice&amp;wr_id=631&amp;page=">블라블라 신규 회원 도서 증정 이벤트   안내</a></span>
                          <span class="t_asr"></span></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <div class="row"></div>
        <div class="row">
          <div class="col-10"></div>
          <button type="button" value="submit" class="genric-btn info circle" style="float: right;">수정</button>
          &nbsp;&nbsp;
          <button type="button" value="submit" class="genric-btn info circle" style="float: right;">삭제</button>
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
  </body>
</html>
