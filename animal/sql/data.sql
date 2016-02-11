/* 회원 정보 입력 */
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD,MEM_IMG) 
  values('관리자1','admin1@test.com','rpdlek','default.jpg');

/* 수신함 내용 입력 */
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(1,1,'HIHI',false,now());

/* 내 펫 추가하기 */
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR,PET_IMG,INJECTION)
  values('1','상훈찡','DOG','포메라이안','#4ed15d','dog.png','접종완료');
  
/* 카테고리 명 등록 */
insert into Category(CATE_CODE,CATE_NAME) values('ILJUNG','일정');
insert into Category(CATE_CODE,CATE_NAME) values('JARANG','자랑하기');
insert into Category(CATE_CODE,CATE_NAME) values('SANCHE','산책코스');

/* 일정등록 */
insert into Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR,PET_SPEC)
  values(1,1,'2016-02-17','2016-02-17',now(),'주사맞자~','1차예방접종','ILJUNG','#4ed15d','DOG');
  
insert into files(FILE_NAME,SCH_NUM,width,height)
  values ('dog.png', 1, 512, 512);
  
/* 자랑하기 등록 */
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(1,1,'2016-02-17','2016-02-17',now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','JARANG',true,'#4ed15d','CAT');
  
insert into files(FILE_NAME,SCH_NUM,width,height)
  values ('cat.png', 2, 512, 512);

/* 산책코스 등록 */
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(1,1,'2016-02-17','2016-02-17',now(),'콩이랑 다녀왔어요~','너무 이쁜거 있죠? 여러분도 다녀오세요','SANCHE',true,'#4ed15d','DOG');
  
insert into files(FILE_NAME,SCH_NUM,width,height)
  values ('dog.png', 3, 512, 512);

/* 산책코스 좌표 */
insert into
  location(LOC_LAT,LOC_LNG,LOC_NAME,LOC_DONG,SCH_NUM)
  values(37.56527502361826, 126.98184460880351, '여기는 어디', '서울시 강남구?', 3);
  

/* 짝짓기 내용 추가 */
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('짝짓기 시즌이에요~','서울 강남역 근처','DOG','포메라이안', true, now(), 1);  
  
insert into files(FILE_NAME,MAT_NUM,width,height)
  values ('dog.png', 1, 512, 512);
  
/* 분양 내용 추가 */
insert into sale(S_TITLE,S_CONTENT,S_SPEC,S_TYPE,S_GEN,S_CRE,S_COST,MEM_NUM) 
    values('분양합니다~','말티즈에용','DOG','말티즈',false,now(),30000,1);
  
insert into files(FILE_NAME,S_NUM,width,height)
  values ('dog.png', 1, 512, 512);


