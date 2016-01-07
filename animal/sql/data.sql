/* 회원 정보 입력 */
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD) 
  values('관리자1','admin1@test.com','rpdlek');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD) 
  values('관리자2','admin2@test.com','rpdlek');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD) 
  values('관리자3','admin3@test.com','rpdlek');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD) 
  values('관리자4','admin4@test.com','rpdlek');

/* 쪽지 내용 입력 */
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(1,2,'HIHI',true);
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(2,1,'HELLO',true);
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(3,2,'GAY',false);
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(2,4,'YO',true);
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(4,1,'CSS',false);

/* 교육 내용 입력 */
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('포메라이안 교육','교육이다아아앙1','DIV01',now(),1);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('냐옹이 교육','교육이다아아앙2','DIV02','2015-01-01',1);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('송사리 교육','교육이다아아앙3','DIV03',now(),2);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('상어 교육','교육이다아아앙4','DIV03','2016-01-01',3);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('앵무새 교육','교육이다아아앙5','DIV04','2015-12-30',2);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('악어 교육','교육이다아아앙6','DIV05',now(),3);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('타조 교육','교육이다아아앙7','DIV04',now(),4);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('시베리안 허스키 교육','교육이다아아앙8','DIV01','2015-12-01',3);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('페르시안 교육','교육이다아아앙9','DIV02','2015-03-27',2);
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_TYPE,EDU_CRE,MEM_NUM)
  values('터키 앙고라 교육','교육이다아아앙10','DIV02','2016-01-05',3);

/* 내 펫 추가하기 */
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('1','강현찡','포메라이안','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('1','상훈찡','시베리안허스키','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('2','지호찡','자라','#FF1234');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('3','대진꽁','거북이','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('3','냥냥이','크로크다일','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('4','갓쥐','이구아나','#FF1211');
insert into Pet(MEM_NUM,PET_NAME,PET_TYPE,TAG_COLOR)
  values('4','야꽐라','코알라','#123421');

  
/* 짝짓기 내용 추가 */
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~1','서울 강남역 근처로 부탁드려요~','DIV01','포메라이안',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~2','서울 강남역 근처로 부탁드려요~','DIV02','페르시안',false,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~3','서울 강남역 근처로 부탁드려요~','DIV01','시베리안허스키',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~4','서울 강남역 근처로 부탁드려요~','DIV01','슈나우져',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~5','서울 강남역 근처로 부탁드려요~','DIV01','불독',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~6','서울 강남역 근처로 부탁드려요~','DIV02','집고양이',false,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~7','우리 아이 부탁드려요~~~~','DIV05','악어',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~8','나이는 어려용~~~','DIV04','비둘기',false,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~9','서울 강남역 근처로 부탁드려요~','DIV04','앵무새',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 짝짓기 부탁해요~~~10','서울 강남역 근처로 부탁드려요~','DIV01','누렁이',true,now());
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE)
  values('우리 아이 한번 하게 해주~~~11','서울 강남역 근처로 부탁드려요~','DIV01','진돗개',true,now());


/* 분양 글쓰기 */
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'퓨마 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','퓨마',1);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values('2015-01-01','콩이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV01','시츄',4);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values('2016-01-02','츄롤리 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','거북이',3);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values('2013-01-01','꽐라 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','코알라',2);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'꽁양이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV04','앵무새',4);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'퓨마 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','퓨마',1);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values('2016-01-03','콩이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV01','시츄',2);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'츄롤리 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','거북이',2);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'꽐라 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV05','코알라',3);
insert into Sale(S_CRE,S_TITLE,S_CONTENT,S_SPEC,S_TYPE,MEM_NUM)
  values(now(),'꽁양이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','DIV03','상어',4);
  
  
/* 카테고리 명 등록 */
insert into Category(CATE_CODE,CATE_NAME) values('ILJUNG','일정');
insert into Category(CATE_CODE,CATE_NAME) values('JARANG','자랑하기');
insert into Category(CATE_CODE,CATE_NAME) values('SANCHE','산책코스');

/* 일정등록 */
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR)
  values(6,'2016-01-01','2016-01-10','2016-01-10','주사맞자~','1차예방접종','ILJUNG','#988752');
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR)
  values(5,'2016-01-01','2016-01-10','2016-01-10','예방접종','3차예방접종','ILJUNG','#120982');
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR)
  values(2,'2016-01-01','2016-01-10','2016-01-10','검진받기','종합 검진 받기','ILJUNG','#123456');
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR)
  values(3,'2016-01-01','2016-01-10','2016-01-10','약 받기','약받으러 병원으로','ILJUNG','#001122');

  
/* 자랑하기 등록 */
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(4,now(),now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','JARANG',false,'#123098');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(2,now(),now(),now(),'반해버렸어요','너무 이쁜거 있죠?','JARANG',true,'#123456');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(1,now(),now(),now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','JARANG',true,'#000000');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(1,now(),now(),now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','JARANG',false,'#000000');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(3,now(),now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','JARANG',true,'#001122');

/* 산책코스 등록 */
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(5,now(),now(),now(),'콩이랑 다녀왔어요~','너무 이쁜거 있죠? 여러분도 다녀오세요','SANCHE',false,'#120982');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(3,now(),now(),now(),'반해버렸어요','너무 이쁜거 있죠?','SANCHE',true,'#001122');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(3,now(),now(),now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','SANCHE',false,'#001122');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(7,now(),now(),now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','SANCHE',false,'#572985');
insert into 
  Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR)
  values(6,now(),now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','SANCHE',true,'#988752');
  
/* Comment */
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) values('너무 이뻐요~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) values('너무 이뻐요~',3,2);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) values('너무 이뻐요~',4,2);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
  values('잘 키우고 싶네여 도움이 많이 되요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) values('너무 이뻐요~',2,2);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
  values('이런 방법이 있군요~',3,3);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) values('너무 이뻐요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) values('너무 이뻐요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) values('너무 이뻐요~',1,3);
insert into Comment(CMT_CONTENT,MEM_NUM,S_NUM) 
  values('너무 분양 받고 싶어요~~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,S_NUM) 
  values('죄송해요 분양이 끝났어요~',2,2);
insert into Comment(CMT_CONTENT,MEM_NUM,S_NUM) 
  values('너무 아쉽네~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,S_NUM) 
  values('이쁜 아이 데려가고 싶네요~',3,1);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('저희 아가랑 짝짓기 하실래요?',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('네 ~ 좋아요~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('꽐라꽐라~~~~',3,9);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
  values('너무 이뻐요~?',1,7);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
  values('어쩜 이리 이뻐요~?',1,9);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
  values('길이 너무 좋은 것 같아요 꼭 가볼게요~',3,11);