-- 교육
ALTER TABLE Education
  DROP FOREIGN KEY FK_Member_TO_Education; -- 회원 -> 교육

-- 분양
ALTER TABLE Sale
  DROP FOREIGN KEY FK_Member_TO_Sale; -- 회원 -> 분양

-- 짝짓기
ALTER TABLE Mating
  DROP FOREIGN KEY FK_Member_TO_Mating; -- 회원 -> 짝짓기

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Member_TO_Comment; -- 회원 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Education_TO_Comment; -- 교육 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Sale_TO_Comment; -- 분양 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Mating_TO_Comment; -- 짝짓기 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Schedule_TO_Comment; -- 다이어리 - 일정 -> 댓글

-- 팻
ALTER TABLE Pet
  DROP FOREIGN KEY FK_Member_TO_Pet; -- 회원 -> 팻

-- 다이어리 - 일정
ALTER TABLE Schedule
  DROP FOREIGN KEY FK_Category_TO_Schedule; -- 카테고리 -> 다이어리 - 일정

-- 다이어리 - 일정
ALTER TABLE Schedule
  DROP FOREIGN KEY FK_Member_TO_Schedule; -- 회원 -> 다이어리 - 일정

-- 파일
ALTER TABLE Files
  DROP FOREIGN KEY FK_Sale_TO_Files; -- 분양 -> 파일

-- 파일
ALTER TABLE Files
  DROP FOREIGN KEY FK_Mating_TO_Files; -- 짝짓기 -> 파일

-- 파일
ALTER TABLE Files
  DROP FOREIGN KEY FK_Education_TO_Files; -- 교육 -> 파일

-- 파일
ALTER TABLE Files
  DROP FOREIGN KEY FK_Schedule_TO_Files; -- 다이어리 - 일정 -> 파일

-- 새 테이블
ALTER TABLE LOCATION
  DROP FOREIGN KEY FK_Schedule_TO_LOCATION; -- 다이어리 - 일정 -> 새 테이블

-- 회원
ALTER TABLE Member
  DROP PRIMARY KEY; -- 회원 기본키

-- 쪽지
ALTER TABLE RECEIVEBOX
  DROP PRIMARY KEY; -- 쪽지 기본키

-- 교육
ALTER TABLE Education
  DROP PRIMARY KEY; -- 교육 기본키

-- 분양
ALTER TABLE Sale
  DROP PRIMARY KEY; -- 분양 기본키

-- 짝짓기
ALTER TABLE Mating
  DROP PRIMARY KEY; -- 짝짓기 기본키

-- 댓글
ALTER TABLE Comment
  DROP PRIMARY KEY; -- 댓글 기본키

-- 팻
ALTER TABLE Pet
  DROP PRIMARY KEY; -- 팻 기본키

-- 다이어리 - 일정
ALTER TABLE Schedule
  DROP PRIMARY KEY; -- 다이어리 - 일정 기본키

-- 파일
ALTER TABLE Files
  DROP PRIMARY KEY; -- 파일 기본키

-- 카테고리
ALTER TABLE Category
  DROP PRIMARY KEY; -- 카테고리 기본키

-- 쪽지2
ALTER TABLE LIKES
  DROP PRIMARY KEY; -- 쪽지2 기본키

-- 새 테이블
ALTER TABLE LOCATION
  DROP PRIMARY KEY; -- 새 테이블 기본키

-- 회원
DROP TABLE IF EXISTS Member RESTRICT;

-- 쪽지
DROP TABLE IF EXISTS RECEIVEBOX RESTRICT;

-- 교육
DROP TABLE IF EXISTS Education RESTRICT;

-- 분양
DROP TABLE IF EXISTS Sale RESTRICT;

-- 짝짓기
DROP TABLE IF EXISTS Mating RESTRICT;

-- 댓글
DROP TABLE IF EXISTS Comment RESTRICT;

-- 팻
DROP TABLE IF EXISTS Pet RESTRICT;

-- 다이어리 - 일정
DROP TABLE IF EXISTS Schedule RESTRICT;

-- 파일
DROP TABLE IF EXISTS Files RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS Category RESTRICT;

-- 쪽지2
DROP TABLE IF EXISTS LIKES RESTRICT;

-- 새 테이블
DROP TABLE IF EXISTS LOCATION RESTRICT;

-- 회원
CREATE TABLE Member (
  MEM_NUM   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  MEM_NAME  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  MEM_EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  MEM_PWD   VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
  MEM_TEL   VARCHAR(30)  NULL     COMMENT '전화번호', -- 전화번호
  MEM_IMG   VARCHAR(255) NULL     COMMENT '회원이미지' -- 회원이미지
)
COMMENT '회원';

-- 회원
ALTER TABLE Member
  ADD CONSTRAINT PK_Member -- 회원 기본키
    PRIMARY KEY (
      MEM_NUM -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_Member
  ON Member ( -- 회원
    MEM_EMAIL ASC -- 이메일
  );

ALTER TABLE Member
  MODIFY COLUMN MEM_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 쪽지
CREATE TABLE RECEIVEBOX (
  MSG_NUM     INTEGER  NOT NULL COMMENT '쪽지번호', -- 쪽지번호
  MEM_NUM     INTEGER  NOT NULL COMMENT '보내는이', -- 보내는이
  MEM_NUM2    INTEGER  NOT NULL COMMENT '받는이', -- 받는이
  MSG_CONTENT TEXT     NOT NULL COMMENT '내용', -- 내용
  CHECKED     BOOLEAN  NOT NULL DEFAULT 0 COMMENT '조회상태', -- 조회상태
  SEND_DATE   DATETIME NOT NULL COMMENT '작성일' -- 작성일
)
COMMENT '쪽지';

-- 쪽지
ALTER TABLE RECEIVEBOX
  ADD CONSTRAINT PK_RECEIVEBOX -- 쪽지 기본키
    PRIMARY KEY (
      MSG_NUM -- 쪽지번호
    );

ALTER TABLE RECEIVEBOX
  MODIFY COLUMN MSG_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '쪽지번호';

-- 교육
CREATE TABLE Education (
  EDU_NUM     INTEGER      NOT NULL COMMENT '교육번호', -- 교육번호
  EDU_VIEWS   INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
  EDU_CRE     DATETIME     NOT NULL COMMENT '작성일', -- 작성일
  EDU_TITLE   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  EDU_CONTENT TEXT         NOT NULL COMMENT '내용', -- 내용
  EDU_SPEC    char(5)      NOT NULL COMMENT '구분', -- 구분
  EDU_LIKES   INTEGER      NOT NULL DEFAULT 0 COMMENT '새 컬럼', -- 새 컬럼
  MEM_NUM     INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '교육';

-- 교육
ALTER TABLE Education
  ADD CONSTRAINT PK_Education -- 교육 기본키
    PRIMARY KEY (
      EDU_NUM -- 교육번호
    );

ALTER TABLE Education
  MODIFY COLUMN EDU_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '교육번호';

-- 분양
CREATE TABLE Sale (
  S_NUM     INTEGER     NOT NULL COMMENT '분양번호', -- 분양번호
  S_CRE     DATETIME    NOT NULL COMMENT '작성일', -- 작성일
  S_VIEWS   INTEGER     NULL     DEFAULT 0 COMMENT '새 컬럼', -- 새 컬럼
  S_LIKES   INTEGER     NULL     DEFAULT 0 COMMENT '새 컬럼2', -- 새 컬럼2
  S_TITLE   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  S_CONTENT TEXT        NOT NULL COMMENT '내용', -- 내용
  S_SPEC    char(5)     NOT NULL COMMENT '구분', -- 구분
  S_TYPE    TEXT        NOT NULL COMMENT '종류', -- 종류
  S_COST    INTEGER     NULL     COMMENT '판매금', -- 판매금
  MEM_NUM   INTEGER     NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '분양';

-- 분양
ALTER TABLE Sale
  ADD CONSTRAINT PK_Sale -- 분양 기본키
    PRIMARY KEY (
      S_NUM -- 분양번호
    );

ALTER TABLE Sale
  MODIFY COLUMN S_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '분양번호';

-- 짝짓기
CREATE TABLE Mating (
  MAT_NUM     INTEGER     NOT NULL COMMENT '짝짓기번호', -- 짝짓기번호
  MAT_VIEWS   INTEGER     NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
  MAT_CRE     DATE        NOT NULL COMMENT '작성일', -- 작성일
  MAT_TITLE   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  MAT_CONTENT TEXT        NOT NULL COMMENT '내용', -- 내용
  MAT_SPEC    char(5)     NOT NULL COMMENT '구분', -- 구분
  MAT_TYPE    TEXT        NOT NULL COMMENT '종', -- 종
  MAT_GEN     BOOLEAN     NOT NULL COMMENT '성별', -- 성별
  MAT_COST    INTEGER     NULL     COMMENT '중매금', -- 중매금
  MEM_NUM     INTEGER     NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '짝짓기';

-- 짝짓기
ALTER TABLE Mating
  ADD CONSTRAINT PK_Mating -- 짝짓기 기본키
    PRIMARY KEY (
      MAT_NUM -- 짝짓기번호
    );

ALTER TABLE Mating
  MODIFY COLUMN MAT_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '짝짓기번호';

-- 댓글
CREATE TABLE Comment (
  CMT_NUM     INTEGER      NOT NULL COMMENT '댓글번호', -- 댓글번호
  CMT_CONTENT TEXT         NOT NULL COMMENT '내용', -- 내용
  CMT_IMG     VARCHAR(255) NULL     COMMENT '이미지', -- 이미지
  MEM_NUM     INTEGER      NULL     COMMENT '회원번호', -- 회원번호
  SCH_NUM     INTEGER      NULL     COMMENT '일정번호', -- 일정번호
  EDU_NUM     INTEGER      NULL     COMMENT '교육번호', -- 교육번호
  S_NUM       INTEGER      NULL     COMMENT '분양번호', -- 분양번호
  MAT_NUM     INTEGER      NULL     COMMENT '짝짓기번호' -- 짝짓기번호
)
COMMENT '댓글';

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT PK_Comment -- 댓글 기본키
    PRIMARY KEY (
      CMT_NUM -- 댓글번호
    );

ALTER TABLE Comment
  MODIFY COLUMN CMT_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 팻
CREATE TABLE Pet (
  PET_NUM   INTEGER      NOT NULL COMMENT '팻번호', -- 팻번호
  MEM_NUM   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  PET_NAME  VARCHAR(50)  NOT NULL COMMENT '펫이름', -- 펫이름
  PET_SPEC  char(5)      NULL     COMMENT '새 컬럼', -- 새 컬럼
  PET_TYPE  VARCHAR(50)  NOT NULL COMMENT '종', -- 종
  PET_IMG   VARCHAR(255) NULL     COMMENT '이미지', -- 이미지
  TAG_COLOR CHAR(7)      NOT NULL COMMENT '태그색', -- 태그색
  INJECTION TEXT         NULL     COMMENT '주사', -- 주사
  MEDICINE  TEXT         NULL     COMMENT '약 ' -- 약 
)
COMMENT '팻';

-- 팻
ALTER TABLE Pet
  ADD CONSTRAINT PK_Pet -- 팻 기본키
    PRIMARY KEY (
      PET_NUM -- 팻번호
    );

ALTER TABLE Pet
  MODIFY COLUMN PET_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '팻번호';

-- 다이어리 - 일정
CREATE TABLE Schedule (
  SCH_NUM     INTEGER     NOT NULL COMMENT '일정번호', -- 일정번호
  PET_NUM     INTEGER     NOT NULL COMMENT '팻번호', -- 팻번호
  MEM_NUM     INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  START_DATE  VARCHAR(30) NOT NULL COMMENT '시작일', -- 시작일
  END_DATE    VARCHAR(30) NOT NULL COMMENT '종료일', -- 종료일
  SCH_CRE     DATETIME    NOT NULL COMMENT '작성일', -- 작성일
  SCH_CONTENT TEXT        NULL     COMMENT '내용', -- 내용
  SCH_TITLE   VARCHAR(50) NULL     COMMENT '제목', -- 제목
  CATE_CODE   CHAR(6)     NULL     COMMENT '카테고리코드', -- 카테고리코드
  NOTI_HIDE   BOOLEAN     NOT NULL DEFAULT 0 COMMENT '공개여부', -- 공개여부
  NOTI_VIEWS  INTEGER     NOT NULL DEFAULT 0 COMMENT '조회수', -- 조회수
  NOTI_LIKES  INTEGER     NOT NULL DEFAULT 0 COMMENT '좋아요', -- 좋아요
  TAG_COLOR   CHAR(7)     NOT NULL COMMENT '태그색', -- 태그색
  PET_SPEC    char(5)     NOT NULL COMMENT '새 컬럼' -- 새 컬럼
)
COMMENT '다이어리 - 일정';

-- 다이어리 - 일정
ALTER TABLE Schedule
  ADD CONSTRAINT PK_Schedule -- 다이어리 - 일정 기본키
    PRIMARY KEY (
      SCH_NUM -- 일정번호
    );

ALTER TABLE Schedule
  MODIFY COLUMN SCH_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '일정번호';

-- 파일
CREATE TABLE Files (
  FILE_NUM  INTEGER      NOT NULL COMMENT '파일번호', -- 파일번호
  FILE_NAME VARCHAR(255) NOT NULL COMMENT '파일명', -- 파일명
  width     INTEGER      NULL     COMMENT '새 컬럼', -- 새 컬럼
  height    INTEGER      NULL     COMMENT '새 컬럼2', -- 새 컬럼2
  EDU_NUM   INTEGER      NULL     COMMENT '교육번호', -- 교육번호
  MAT_NUM   INTEGER      NULL     COMMENT '짝짓기번호', -- 짝짓기번호
  S_NUM     INTEGER      NULL     COMMENT '분양번호', -- 분양번호
  SCH_NUM   INTEGER      NULL     COMMENT '일정번호' -- 일정번호
)
COMMENT '파일';

-- 파일
ALTER TABLE Files
  ADD CONSTRAINT PK_Files -- 파일 기본키
    PRIMARY KEY (
      FILE_NUM -- 파일번호
    );

ALTER TABLE Files
  MODIFY COLUMN FILE_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 카테고리
CREATE TABLE Category (
  CATE_CODE CHAR(6)     NOT NULL COMMENT '카테고리코드', -- 카테고리코드
  CATE_NAME VARCHAR(50) NOT NULL COMMENT '카테고리명' -- 카테고리명
)
COMMENT '카테고리';

-- 카테고리
ALTER TABLE Category
  ADD CONSTRAINT PK_Category -- 카테고리 기본키
    PRIMARY KEY (
      CATE_CODE -- 카테고리코드
    );

-- 카테고리 유니크 인덱스
CREATE UNIQUE INDEX UIX_Category
  ON Category ( -- 카테고리
    CATE_NAME ASC -- 카테고리명
  );

-- 쪽지2
CREATE TABLE LIKES (
  LIKE_NUM INTEGER NOT NULL COMMENT '쪽지번호', -- 쪽지번호
  MEM_NUM  INTEGER NOT NULL COMMENT '보내는이', -- 보내는이
  EDU_NUM  INTEGER NULL     COMMENT '새 컬럼', -- 새 컬럼
  MAT_NUM  INTEGER NULL     COMMENT '새 컬럼2', -- 새 컬럼2
  S_NUM    INTEGER NULL     COMMENT '새 컬럼3', -- 새 컬럼3
  SCH_NUM  INTEGER NULL     COMMENT '새 컬럼4' -- 새 컬럼4
)
COMMENT '쪽지2';

-- 쪽지2
ALTER TABLE LIKES
  ADD CONSTRAINT PK_LIKES -- 쪽지2 기본키
    PRIMARY KEY (
      LIKE_NUM -- 쪽지번호
    );

ALTER TABLE LIKES
  MODIFY COLUMN LIKE_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '쪽지번호';

-- 새 테이블
CREATE TABLE LOCATION (
  LOC_NUM  INTEGER      NOT NULL COMMENT '새 컬럼3', -- 새 컬럼3
  LOC_LAT  VARCHAR(255) NOT NULL COMMENT '새 컬럼', -- 새 컬럼
  LOC_LNG  VARCHAR(255) NOT NULL COMMENT '새 컬럼2', -- 새 컬럼2
  LOC_NAME VARCHAR(255) NOT NULL COMMENT '새 컬럼4', -- 새 컬럼4
  LOC_DONG VARCHAR(255) NULL     COMMENT '새 컬럼5', -- 새 컬럼5
  SCH_NUM  INTEGER      NOT NULL COMMENT '일정번호' -- 일정번호
)
COMMENT '새 테이블';

-- 새 테이블
ALTER TABLE LOCATION
  ADD CONSTRAINT PK_LOCATION -- 새 테이블 기본키
    PRIMARY KEY (
      LOC_NUM -- 새 컬럼3
    );

ALTER TABLE LOCATION
  MODIFY COLUMN LOC_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '새 컬럼3';

-- 교육
ALTER TABLE Education
  ADD CONSTRAINT FK_Member_TO_Education -- 회원 -> 교육
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 분양
ALTER TABLE Sale
  ADD CONSTRAINT FK_Member_TO_Sale -- 회원 -> 분양
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 짝짓기
ALTER TABLE Mating
  ADD CONSTRAINT FK_Member_TO_Mating -- 회원 -> 짝짓기
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Member_TO_Comment -- 회원 -> 댓글
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Education_TO_Comment -- 교육 -> 댓글
    FOREIGN KEY (
      EDU_NUM -- 교육번호
    )
    REFERENCES Education ( -- 교육
      EDU_NUM -- 교육번호
    )on delete cascade;

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Sale_TO_Comment -- 분양 -> 댓글
    FOREIGN KEY (
      S_NUM -- 분양번호
    )
    REFERENCES Sale ( -- 분양
      S_NUM -- 분양번호
    )on delete cascade;

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Mating_TO_Comment -- 짝짓기 -> 댓글
    FOREIGN KEY (
      MAT_NUM -- 짝짓기번호
    )
    REFERENCES Mating ( -- 짝짓기
      MAT_NUM -- 짝짓기번호
    )on delete cascade;

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Schedule_TO_Comment -- 다이어리 - 일정 -> 댓글
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    )on delete cascade;

-- 팻
ALTER TABLE Pet
  ADD CONSTRAINT FK_Member_TO_Pet -- 회원 -> 팻
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 다이어리 - 일정
ALTER TABLE Schedule
  ADD CONSTRAINT FK_Category_TO_Schedule -- 카테고리 -> 다이어리 - 일정
    FOREIGN KEY (
      CATE_CODE -- 카테고리코드
    )
    REFERENCES Category ( -- 카테고리
      CATE_CODE -- 카테고리코드
    )on delete cascade;

-- 다이어리 - 일정
ALTER TABLE Schedule
  ADD CONSTRAINT FK_Member_TO_Schedule -- 회원 -> 다이어리 - 일정
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    )on delete cascade;

-- 파일
ALTER TABLE Files
  ADD CONSTRAINT FK_Sale_TO_Files -- 분양 -> 파일
    FOREIGN KEY (
      S_NUM -- 분양번호
    )
    REFERENCES Sale ( -- 분양
      S_NUM -- 분양번호
    )on delete cascade;

-- 파일
ALTER TABLE Files
  ADD CONSTRAINT FK_Mating_TO_Files -- 짝짓기 -> 파일
    FOREIGN KEY (
      MAT_NUM -- 짝짓기번호
    )
    REFERENCES Mating ( -- 짝짓기
      MAT_NUM -- 짝짓기번호
    )on delete cascade;

-- 파일
ALTER TABLE Files
  ADD CONSTRAINT FK_Education_TO_Files -- 교육 -> 파일
    FOREIGN KEY (
      EDU_NUM -- 교육번호
    )
    REFERENCES Education ( -- 교육
      EDU_NUM -- 교육번호
    )on delete cascade;

-- 파일
ALTER TABLE Files
  ADD CONSTRAINT FK_Schedule_TO_Files -- 다이어리 - 일정 -> 파일
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    )on delete cascade;

-- 새 테이블
ALTER TABLE LOCATION
  ADD CONSTRAINT FK_Schedule_TO_LOCATION -- 다이어리 - 일정 -> 새 테이블
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    )on delete cascade;