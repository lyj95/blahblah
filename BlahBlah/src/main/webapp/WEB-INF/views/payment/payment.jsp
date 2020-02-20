<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script type="text/javascript">
    $(document).ready(function(){
    	//window.IMP 변수 초기화
        var IMP = window.IMP; 				
        IMP.init('imp47682044'); 			// 가맹점 식별코드
        var msg;
        
        var lessonNo = ${lessonNo};
        var lessonPrice = ${lessonPrice};
        var userId = "${userId}";
        var userName = "${userName}";
        var userEmail = "${userEmail}";
        
        IMP.request_pay({					//IMP.request_pay(param, callback)  2개의 argument를 받는 함수
            pg : 'kakaopay',				//PG사
            pay_method : 'card',			//결제수단
            merchant_uid : 'merchant_' + new Date().getTime(),	//가맹점에서 생성/관리하는 고유주문번호(필수항목)
            name : 'BlahBlah 강의 결제',		//주문명
            amount : lessonPrice,			//결제할 금액(필수항목)
            buyer_name : userName,
            buyer_email : userEmail
            //m_redirect_url : 'http://www.naver.com' 모바일 결제 후 이동될 주소
            
        }, function(rsp) {					//결제 후 호출되는 callback함수(가맹점 서버로 imp_uid 전달)
        
            if ( rsp.success ) {			//실제 결제승인이 이루어진 경우 true
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
               	
                jQuery.ajax({
                    url: "blahpay", 		// /payments/complete cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    contentType:"application/json",
                    data: JSON.stringify({				//서버로 보낼 데이터
                        'impUid' : rsp.imp_uid,			//아임포트 거래고유번호, 서버단에서 REST API로 조회 후 검증
                        'paidAmount' : rsp.paid_amount,	//결제 금액 서버단에서 계산한 {실제주문금액}과 일치하는지 최종 검증 
                        'lessonNo'	: lessonNo,
                        'userId' : userId	
                    })
                     
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( data.everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid; 				//아임포트 거래고유번호
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;		//가맹점에서 전달한 주문 고유번호
                        msg += '\n결제 금액 : ' + rsp.paid_amount;
                        msg += '\n카드 승인번호 : ' + rsp.apply_num;			//카드 승인번호(카드로 결제시만)
                      	console.log(msg);
                        alert("결제가 완료되었습니다. 마이페이지에서 확인바랍니다.");
                        
                      	//성공시 이동할 페이지
                        location.href='courseDetail?lessonNo=${lessonNo}';
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                        alert("결제할 수 없습니다. 결제 정보를 다시 확인해주세요.");
                    	
                      	//실패시 이동할 페이지
                        location.href='courseDetail?lessonNo=${lessonNo}';
                    }
                });
                
            } else {	//결제실패
                msg = '결제에 실패하였습니다. \n';
                msg += '에러내용 : ' + rsp.error_msg;	//결제처리에 실패한 경우 상세메세지
                alert(msg);
                
                //실패시 이동할 페이지
                location.href='courseDetail?lessonNo=${lessonNo}';
            }
        });
        
    });
    </script>
 
</body>
</html>
