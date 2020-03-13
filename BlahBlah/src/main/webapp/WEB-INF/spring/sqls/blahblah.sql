-- 쿼리문 추가해서 실행하는 건 developer에서 해주면 감사함다 !! 컬럼 추가하고 commit 하는거 잊지 말기 ~!
-- 여기는 테이블 수정된거 계속해서 업데이트하는 용도로 사용할게요 !
-- 블라블라 화이팅 ^____^;


















-- DROP
DROP TABLE member;
DROP TABLE lesson;
DROP TABLE myclass;
DROP TABLE files;
DROP TABLE tutor;
DROP TABLE notice;
DROP TABLE qna;
DROP TABLE review;
DROP TABLE reply;
DROP TABLE payment;
DROP TABLE calendar;
DROP TABLE leveltest;
DROP TABLE fav;
DROP TABLE feedbacks;
DROP SEQUENCE lesson_seq;
DROP SEQUENCE notice_seq;
DROP SEQUENCE qna_seq;
DROP SEQUENCE member_seq;
DROP SEQUENCE review_seq;
-- 시퀀스 생성

CREATE SEQUENCE lesson_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;
CREATE SEQUENCE notice_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;
CREATE SEQUENCE qna_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;
  
CREATE SEQUENCE review_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 1
  NOCYCLE;  
-- 테이블 생성
CREATE TABLE member (
	member_id	varchar2(100)	PRIMARY KEY,
	member_pw	varchar2(100)	NOT NULL,
	member_type	varchar2(20)	NOT NULL,
	member_name	varchar2(100)	NOT NULL,
	member_email	varchar2(200)	NOT NULL,
	member_level	varchar2(20),
	member_photo	varchar2(4000),
    member_enabled   varchar2(10) NOT NULL,
    CONSTRAINT member_enabled_chk CHECK(member_enabled IN('Y','N')),
    CONSTRAINT member_type_chk CHECK(member_type IN('ADMIN','USER','TUTOR'))
);
CREATE TABLE lesson (
	lesson_no	number	PRIMARY KEY,
	lesson_name	varchar2(700)	NOT NULL,
	lesson_info	varchar2(4000)	NOT NULL,
	lesson_level	varchar2(20)	NOT NULL,
	lesson_type	varchar2(100)	NOT NULL,
	lesson_time	varchar2(500)	NOT NULL,
	lesson_price	number	NOT NULL,
	lesson_total	number	NOT NULL,
	tutor_id	varchar2(100)	NOT NULL,
    lesson_sample varchar2(4000) ,
    LESSON_START VARCHAR2(50),
    member_photo VARCHAR2(4000),
    CONSTRAINT lesson_type_chk CHECK(lesson_type IN('SPEAKING','LICENSE'))
);
CREATE TABLE myclass (
	lesson_no	number	NOT NULL,
	member_id	varchar2(100)	NOT NULL,
	myclass_totalcnt	number	NOT NULL,
	myclass_remaincnt	number	NOT NULL,
	payment_day	Date	NOT NULL,
    imp_uid VARCHAR2(200) NOT NULL,
    myclass_date1 Date,
    myclass_date2 Date,
    myclass_date3 Date,
    myclass_date4 Date
);

-- 하나의 강의에 하나의 파일?
CREATE TABLE files (
	lesson_no	number	NOT NULL,
	files_type	varchar2(100)	NOT NULL,
	files_dir	varchar2(4000)	NOT NULL,
	FILES_NAME VARCHAR2(4000) 
);
CREATE TABLE tutor (
	tutor_id	varchar2(100)	PRIMARY KEY,
	tutor_info	varchar2(4000)
);
CREATE TABLE notice (
	notice_no	number	PRIMARY KEY,
	notice_title	varchar2(500)	NOT NULL,
	notice_content	varchar2(4000)	NOT NULL,
	notice_date	Date	NOT NULL,
	notice_view	number,
    notice_important number
);
CREATE TABLE qna (
   qna_no   number   PRIMARY KEY,
   member_id   varchar2(100)   NOT NULL,
   qna_title   varchar2(500)   NOT NULL,
   qna_content   varchar2(4000)   NOT NULL,
   qna_date   Date   NOT NULL,
   qna_rep   varchar2(2)   NOT NULL,
   qna_open   varchar2(2)   NOT NULL,
    CONSTRAINT qna_rep_chk CHECK(qna_rep IN('Y','N')),
    CONSTRAINT qna_open_chk CHECK(qna_open IN('Y','N'))
);

CREATE TABLE review (
    review_seq number PRIMARY KEY,	
	member_id	varchar2(100)	NOT NULL,
	lesson_no	number	NOT NULL,
	review_content	varchar2(4000)	NOT NULL,
	review_date	Date	NOT NULL,
	review_grade	number	,
	member_photo VARCHAR2(4000)
);
CREATE TABLE reply (
	qna_no	number	PRIMARY KEY,
	reply_date	Date	NOT NULL,
	reply_content	varchar2(4000)	NOT NULL
);
CREATE TABLE payment (
	member_id	varchar2(100) NOT NULL,
	lesson_no	number	NOT NULL,
	payment_day	Date	NOT NULL,
	imp_uid VARCHAR2(200) NOT NULL
);
CREATE TABLE calendar (
	calendar_date	Date	NOT NULL,
	member_id	varchar2(100)	NOT NULL,
	calendar_content	varchar2(1000)	
);
CREATE TABLE leveltest (
	leveltest_no	number	NOT NULL,
	leveltest_answer	varchar2(2)	NOT NULL,
	member_id	varchar2(100)	NOT NULL
);
CREATE TABLE fav (
	member_id	varchar2(100)	NOT NULL,
	lesson_no	number	NOT NULL
);

CREATE TABLE feedbacks (
    lesson_no number,
    member_id varchar2(100),
    class_date Date,
    feedback_txt varchar2(1000)
);


-- 복합 기본키 제약조건

-- myclass
ALTER TABLE myclass ADD CONSTRAINT PK_MYCLASS PRIMARY KEY (
    lesson_no,
	member_id
);

ALTER TABLE feedbacks ADD CONSTRAINT PK_FEEDBACKS PRIMARY KEY (
	member_id,
	lesson_no,
    class_date
);

ALTER TABLE payment ADD CONSTRAINT PK_PAYMENT PRIMARY KEY (
	member_id,
	lesson_no
);

--ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
--	member_id,
--	lesson_no
--);
ALTER TABLE calendar ADD CONSTRAINT PK_CALENDAR PRIMARY KEY (
	calendar_date,
	member_id
);
ALTER TABLE leveltest ADD CONSTRAINT PK_LEVELTEST PRIMARY KEY (
	leveltest_no,
	leveltest_answer,
	member_id
);
ALTER TABLE fav ADD CONSTRAINT PK_FAV PRIMARY KEY (
	member_id,
	lesson_no
);


-- 외래키 제약조건
ALTER TABLE feedbacks ADD CONSTRAINT FK_feedbacks FOREIGN KEY (
	lesson_no,
    member_id
)
REFERENCES myclass (
	lesson_no,
    member_id
);


ALTER TABLE myclass ADD CONSTRAINT FK_les_mclass FOREIGN KEY (
	lesson_no
)
REFERENCES lesson (
	lesson_no
);
ALTER TABLE files ADD CONSTRAINT FK_les_files FOREIGN KEY (
	lesson_no
)
REFERENCES lesson (
	lesson_no
);
ALTER TABLE tutor ADD CONSTRAINT FK_mem_tutor FOREIGN KEY (
	tutor_id
)
REFERENCES member (
	member_id
);
ALTER TABLE review ADD CONSTRAINT FK_mem_review FOREIGN KEY (
	member_id
)
REFERENCES member (
	member_id
);
ALTER TABLE review ADD CONSTRAINT FK_les_review FOREIGN KEY (
	lesson_no
)
REFERENCES lesson (
	lesson_no
);
ALTER TABLE reply ADD CONSTRAINT FK_qna_reply FOREIGN KEY (
	qna_no
)
REFERENCES qna (
	qna_no
);
ALTER TABLE payment ADD CONSTRAINT FK_member_pay FOREIGN KEY (
	member_id
)
REFERENCES member (
	member_id
);
ALTER TABLE payment ADD CONSTRAINT FK_lesson_pay FOREIGN KEY (
	lesson_no
)
REFERENCES lesson (
	lesson_no
);
ALTER TABLE calendar ADD CONSTRAINT FK_member_cal FOREIGN KEY (
	member_id
)
REFERENCES member (
	member_id
);
ALTER TABLE leveltest ADD CONSTRAINT FK_member_ltest FOREIGN KEY (
	member_id
)
REFERENCES member (
	member_id
);
ALTER TABLE fav ADD CONSTRAINT FK_member_fav FOREIGN KEY (
	member_id
)
REFERENCES member (
	member_id
);
ALTER TABLE fav ADD CONSTRAINT FK_lesson_fav FOREIGN KEY (
	lesson_no
)
REFERENCES lesson (
	lesson_no
);
commit;
