-- 쪽지
ALTER TABLE Message
  DROP FOREIGN KEY FK_Member_TO_Message; -- 회원 -> 쪽지

-- 쪽지
ALTER TABLE Message
  DROP FOREIGN KEY FK_Member_TO_Message2; -- 회원 -> 쪽지2

-- 교육
ALTER TABLE Education
  DROP FOREIGN KEY FK_Member_TO_Education; -- 회원 -> 교육

-- 분양
ALTER TABLE Parcel_Out
  DROP FOREIGN KEY FK_Member_TO_Parcel_Out; -- 회원 -> 분양

-- 짝짓기
ALTER TABLE Mating
  DROP FOREIGN KEY FK_Member_TO_Mating; -- 회원 -> 짝짓기

-- 산책코스
ALTER TABLE TABLE6
  DROP FOREIGN KEY FK_Schedule_TO_TABLE6; -- 다이어리 - 일정 -> 산책코스

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Member_TO_Comment; -- 회원 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Education_TO_Comment; -- 교육 -> 댓글

-- 댓글
ALTER TABLE Comment
  DROP FOREIGN KEY FK_Parcel_Out_TO_Comment; -- 분양 -> 댓글

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
  DROP FOREIGN KEY FK_Pet_TO_Schedule; -- 팻 -> 다이어리 - 일정

-- 다이어리 - 일정
ALTER TABLE Schedule
  DROP FOREIGN KEY FK_Category_TO_Schedule; -- 카테고리 -> 다이어리 - 일정

-- 파일
ALTER TABLE File
  DROP FOREIGN KEY FK_Parcel_Out_TO_File; -- 분양 -> 파일

-- 파일
ALTER TABLE File
  DROP FOREIGN KEY FK_Mating_TO_File; -- 짝짓기 -> 파일

-- 파일
ALTER TABLE File
  DROP FOREIGN KEY FK_Education_TO_File; -- 교육 -> 파일

-- 파일
ALTER TABLE File
  DROP FOREIGN KEY FK_Schedule_TO_File; -- 다이어리 - 일정 -> 파일

-- 회원
ALTER TABLE Member
  DROP PRIMARY KEY; -- 회원 기본키

-- 쪽지
ALTER TABLE Message
  DROP PRIMARY KEY; -- 쪽지 기본키

-- 교육
ALTER TABLE Education
  DROP PRIMARY KEY; -- 교육 기본키

-- 분양
ALTER TABLE Parcel_Out
  DROP PRIMARY KEY; -- 분양 기본키

-- 짝짓기
ALTER TABLE Mating
  DROP PRIMARY KEY; -- 짝짓기 기본키

-- 산책코스
ALTER TABLE TABLE6
  DROP PRIMARY KEY; -- 산책코스 기본키

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
ALTER TABLE File
  DROP PRIMARY KEY; -- 파일 기본키

-- 예방접종
ALTER TABLE TABLE12
  DROP PRIMARY KEY; -- 예방접종 기본키

-- 테이블코드
ALTER TABLE TABLE13
  DROP PRIMARY KEY; -- 테이블코드 기본키

-- 카테고리
ALTER TABLE Category
  DROP PRIMARY KEY; -- 카테고리 기본키

-- 회원
DROP TABLE IF EXISTS Member RESTRICT;

-- 쪽지
DROP TABLE IF EXISTS Message RESTRICT;

-- 교육
DROP TABLE IF EXISTS Education RESTRICT;

-- 분양
DROP TABLE IF EXISTS Parcel_Out RESTRICT;

-- 짝짓기
DROP TABLE IF EXISTS Mating RESTRICT;

-- 산책코스
DROP TABLE IF EXISTS TABLE6 RESTRICT;

-- 댓글
DROP TABLE IF EXISTS Comment RESTRICT;

-- 팻
DROP TABLE IF EXISTS Pet RESTRICT;

-- 다이어리 - 일정
DROP TABLE IF EXISTS Schedule RESTRICT;

-- 파일
DROP TABLE IF EXISTS File RESTRICT;

-- 예방접종
DROP TABLE IF EXISTS TABLE12 RESTRICT;

-- 테이블코드
DROP TABLE IF EXISTS TABLE13 RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS Category RESTRICT;

-- 회원
CREATE TABLE Member (
  MEM_NUM   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  MEM_NAME  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  MEM_EMAIL VARCHAR(50)  NOT NULL COMMENT '이메일', -- 이메일
  MEM_PWD   VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
  MEM_TEL   VARCHAR(20)  NULL     COMMENT '전화번호', -- 전화번호
  MEM_IMG   VARCHAR(50)  NULL     COMMENT '회원이미지' -- 회원이미지
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
CREATE TABLE Message (
  MSG_NUM     INTEGER      NOT NULL COMMENT '쪽지번호', -- 쪽지번호
  MEM_NUM     INTEGER      NOT NULL COMMENT '보내는이', -- 보내는이
  MEM_NUM2    INTEGER      NOT NULL COMMENT '받는이', -- 받는이
  MSG_CONTENT VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  COL         BOOLEAN      NULL     COMMENT '조회상태' -- 조회상태
)
COMMENT '쪽지';

-- 쪽지
ALTER TABLE Message
  ADD CONSTRAINT PK_Message -- 쪽지 기본키
    PRIMARY KEY (
      MSG_NUM -- 쪽지번호
    );

ALTER TABLE Message
  MODIFY COLUMN MSG_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '쪽지번호';

-- 교육
CREATE TABLE Education (
  EDU_NUM     INTEGER      NOT NULL COMMENT '교육번호', -- 교육번호
  EDU_VIEWS   INTEGER      NULL     COMMENT '조회수', -- 조회수
  EDU_CRE     DATETIME     NULL     COMMENT '작성일', -- 작성일
  EDU_TITLE   VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  EDU_CONTENT VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  EDU_DIV     VARCHAR(50)  NOT NULL COMMENT '구분', -- 구분
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
CREATE TABLE Parcel_Out (
  PO_NUM     INTEGER      NOT NULL COMMENT '분양번호', -- 분양번호
  PO_CREDT   DATETIME     NULL     COMMENT '작성일', -- 작성일
  PO_TITLE   VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  PO_CONTENT VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  PO_DIV     VARCHAR(50)  NOT NULL COMMENT '구분', -- 구분
  PO_SPECIES VARCHAR(50)  NOT NULL COMMENT '종류', -- 종류
  PO_COST    VARCHAR(50)  NULL     COMMENT '판매금', -- 판매금
  MEM_NUM    INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '분양';

-- 분양
ALTER TABLE Parcel_Out
  ADD CONSTRAINT PK_Parcel_Out -- 분양 기본키
    PRIMARY KEY (
      PO_NUM -- 분양번호
    );

ALTER TABLE Parcel_Out
  MODIFY COLUMN PO_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '분양번호';

-- 짝짓기
CREATE TABLE Mating (
  MAT_NUM     INTEGER      NOT NULL COMMENT '짝짓기번호', -- 짝짓기번호
  MAT_VIEWS   INTEGER      NULL     COMMENT '조회수', -- 조회수
  MAT_CRE     DATETIME     NULL     COMMENT '작성일', -- 작성일
  MAT_TITLE   VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  MAT_CONTENT VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  MAT_DIV     VARCHAR(50)  NOT NULL COMMENT '구분', -- 구분
  MAT_SPECIES VARCHAR(50)  NOT NULL COMMENT '종', -- 종
  MAT_SEX     CHAR(5)      NOT NULL COMMENT '성별', -- 성별
  MAT_COST    VARCHAR(50)  NULL     COMMENT '중매금', -- 중매금
  MEM_NUM     INTEGER      NULL     COMMENT '회원번호' -- 회원번호
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

-- 산책코스
CREATE TABLE TABLE6 (
  COL     <데이터 타입 없음> NOT NULL COMMENT '산책번호', -- 산책번호
  COL2    <데이터 타입 없음> NULL     COMMENT '조회수', -- 조회수
  COL6    <데이터 타입 없음> NULL     COMMENT '좋아요', -- 좋아요
  SCH_NUM INTEGER            NULL     COMMENT '일정번호', -- 일정번호
  COL6    <데이터 타입 없음> NULL     COMMENT '카테고리번호', -- 카테고리번호
  COL3    <데이터 타입 없음> NULL     COMMENT '카테고리번호2' -- 카테고리번호2
)
COMMENT '산책코스';

-- 산책코스
ALTER TABLE TABLE6
  ADD CONSTRAINT PK_TABLE6 -- 산책코스 기본키
    PRIMARY KEY (
      COL -- 산책번호
    );

-- 댓글
CREATE TABLE Comment (
  CMT_NUM     INTEGER      NOT NULL COMMENT '댓글번호', -- 댓글번호
  CMT_CONTENT VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  MEM_NUM     INTEGER      NULL     COMMENT '회원번호', -- 회원번호
  SCH_NUM     INTEGER      NULL     COMMENT '일정번호', -- 일정번호
  EDU_NUM     INTEGER      NULL     COMMENT '교육번호', -- 교육번호
  PO_NUM      INTEGER      NULL     COMMENT '분양번호', -- 분양번호
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
  PET_NUM     INTEGER      NOT NULL COMMENT '팻번호', -- 팻번호
  MEM_NUM     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  PET_NAME    VARCHAR(50)  NOT NULL COMMENT '펫이름', -- 펫이름
  PET_SPECIES VARCHAR(50)  NOT NULL COMMENT '종', -- 종
  PET_IMG     VARCHAR(255) NULL     COMMENT '이미지', -- 이미지
  TAG_COLOR   VARCHAR(50)  NOT NULL COMMENT '태그색', -- 태그색
  INJECTION   VARCHAR(50)  NULL     COMMENT '주사', -- 주사
  MEDICINE    VARCHAR(50)  NULL     COMMENT '약 ' -- 약 
)
COMMENT '팻';

-- 팻
ALTER TABLE Pet
  ADD CONSTRAINT PK_Pet -- 팻 기본키
    PRIMARY KEY (
      PET_NUM -- 팻번호
    );

-- 팻 유니크 인덱스
CREATE UNIQUE INDEX UIX_Pet
  ON Pet ( -- 팻
  );

ALTER TABLE Pet
  MODIFY COLUMN PET_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '팻번호';

-- 다이어리 - 일정
CREATE TABLE Schedule (
  SCH_NUM     INTEGER      NOT NULL COMMENT '일정번호', -- 일정번호
  PET_NUM     INTEGER      NOT NULL COMMENT '팻번호', -- 팻번호
  START_DATE  DATETIME     NOT NULL COMMENT '시작일', -- 시작일
  END_DATE    DATETIME     NOT NULL COMMENT '종료일', -- 종료일
  SCH_CRE     DATETIME     NOT NULL     COMMENT '작성일', -- 작성일
  SCH_CONTENT VARCHAR(255) NULL     COMMENT '내용', -- 내용
  SCH_TITLE   VARCHAR(50)  NULL     COMMENT '제목', -- 제목
  CATE_CODE   CHAR(6)      NULL     COMMENT '카테고리코드', -- 카테고리코드
  NOTI_OPEN   INTEGER      NOT NULL COMMENT '공개여부', -- 공개여부
  NOTI_VIEWS  INTEGER      NULL     COMMENT '조회수', -- 조회수
  NOTI_LIKES  INTEGER      NULL     COMMENT '좋아요' -- 좋아요
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
CREATE TABLE File (
  FILE_NUM  INTEGER     NOT NULL COMMENT '파일번호', -- 파일번호
  FILE_NAME VARCHAR(50) NOT NULL COMMENT '파일명', -- 파일명
  NOTI_NUM  INTEGER     NULL     COMMENT '게시물번호', -- 게시물번호
  EDU_NUM   INTEGER     NULL     COMMENT '교육번호', -- 교육번호
  MAT_NUM   INTEGER     NULL     COMMENT '짝짓기번호', -- 짝짓기번호
  PO_NUM    INTEGER     NULL     COMMENT '분양번호', -- 분양번호
  SCH_NUM   INTEGER     NULL     COMMENT '일정번호' -- 일정번호
)
COMMENT '파일';

-- 파일
ALTER TABLE File
  ADD CONSTRAINT PK_File -- 파일 기본키
    PRIMARY KEY (
      FILE_NUM -- 파일번호
    );

ALTER TABLE File
  MODIFY COLUMN FILE_NUM INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';

-- 예방접종
CREATE TABLE TABLE12 (
  COL  <데이터 타입 없음> NOT NULL COMMENT '예방접종번호', -- 예방접종번호
  COL2 <데이터 타입 없음> NULL     COMMENT 'D_day', -- D_day
  COL3 <데이터 타입 없음> NULL     COMMENT '새 컬럼' -- 새 컬럼
)
COMMENT '예방접종';

-- 예방접종
ALTER TABLE TABLE12
  ADD CONSTRAINT PK_TABLE12 -- 예방접종 기본키
    PRIMARY KEY (
      COL -- 예방접종번호
    );

-- 테이블코드
CREATE TABLE TABLE13 (
  COL  <데이터 타입 없음> NOT NULL COMMENT '테이블코드', -- 테이블코드
  COL2 <데이터 타입 없음> NULL     COMMENT '테이블명' -- 테이블명
)
COMMENT '테이블코드';

-- 테이블코드
ALTER TABLE TABLE13
  ADD CONSTRAINT PK_TABLE13 -- 테이블코드 기본키
    PRIMARY KEY (
      COL -- 테이블코드
    );

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

-- 쪽지
ALTER TABLE Message
  ADD CONSTRAINT FK_Member_TO_Message -- 회원 -> 쪽지
    FOREIGN KEY (
      MEM_NUM -- 보내는이
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 쪽지
ALTER TABLE Message
  ADD CONSTRAINT FK_Member_TO_Message2 -- 회원 -> 쪽지2
    FOREIGN KEY (
      MEM_NUM2 -- 받는이
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 교육
ALTER TABLE Education
  ADD CONSTRAINT FK_Member_TO_Education -- 회원 -> 교육
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 분양
ALTER TABLE Parcel_Out
  ADD CONSTRAINT FK_Member_TO_Parcel_Out -- 회원 -> 분양
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 짝짓기
ALTER TABLE Mating
  ADD CONSTRAINT FK_Member_TO_Mating -- 회원 -> 짝짓기
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 산책코스
ALTER TABLE TABLE6
  ADD CONSTRAINT FK_Schedule_TO_TABLE6 -- 다이어리 - 일정 -> 산책코스
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    );

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Member_TO_Comment -- 회원 -> 댓글
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Education_TO_Comment -- 교육 -> 댓글
    FOREIGN KEY (
      EDU_NUM -- 교육번호
    )
    REFERENCES Education ( -- 교육
      EDU_NUM -- 교육번호
    );

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Parcel_Out_TO_Comment -- 분양 -> 댓글
    FOREIGN KEY (
      PO_NUM -- 분양번호
    )
    REFERENCES Parcel_Out ( -- 분양
      PO_NUM -- 분양번호
    );

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Mating_TO_Comment -- 짝짓기 -> 댓글
    FOREIGN KEY (
      MAT_NUM -- 짝짓기번호
    )
    REFERENCES Mating ( -- 짝짓기
      MAT_NUM -- 짝짓기번호
    );

-- 댓글
ALTER TABLE Comment
  ADD CONSTRAINT FK_Schedule_TO_Comment -- 다이어리 - 일정 -> 댓글
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    );

-- 팻
ALTER TABLE Pet
  ADD CONSTRAINT FK_Member_TO_Pet -- 회원 -> 팻
    FOREIGN KEY (
      MEM_NUM -- 회원번호
    )
    REFERENCES Member ( -- 회원
      MEM_NUM -- 회원번호
    );

-- 다이어리 - 일정
ALTER TABLE Schedule
  ADD CONSTRAINT FK_Pet_TO_Schedule -- 팻 -> 다이어리 - 일정
    FOREIGN KEY (
      PET_NUM -- 팻번호
    )
    REFERENCES Pet ( -- 팻
      PET_NUM -- 팻번호
    );

-- 다이어리 - 일정
ALTER TABLE Schedule
  ADD CONSTRAINT FK_Category_TO_Schedule -- 카테고리 -> 다이어리 - 일정
    FOREIGN KEY (
      CATE_CODE -- 카테고리코드
    )
    REFERENCES Category ( -- 카테고리
      CATE_CODE -- 카테고리코드
    );

-- 파일
ALTER TABLE File
  ADD CONSTRAINT FK_Parcel_Out_TO_File -- 분양 -> 파일
    FOREIGN KEY (
      PO_NUM -- 분양번호
    )
    REFERENCES Parcel_Out ( -- 분양
      PO_NUM -- 분양번호
    );

-- 파일
ALTER TABLE File
  ADD CONSTRAINT FK_Mating_TO_File -- 짝짓기 -> 파일
    FOREIGN KEY (
      MAT_NUM -- 짝짓기번호
    )
    REFERENCES Mating ( -- 짝짓기
      MAT_NUM -- 짝짓기번호
    );

-- 파일
ALTER TABLE File
  ADD CONSTRAINT FK_Education_TO_File -- 교육 -> 파일
    FOREIGN KEY (
      EDU_NUM -- 교육번호
    )
    REFERENCES Education ( -- 교육
      EDU_NUM -- 교육번호
    );

-- 파일
ALTER TABLE File
  ADD CONSTRAINT FK_Schedule_TO_File -- 다이어리 - 일정 -> 파일
    FOREIGN KEY (
      SCH_NUM -- 일정번호
    )
    REFERENCES Schedule ( -- 다이어리 - 일정
      SCH_NUM -- 일정번호
    );