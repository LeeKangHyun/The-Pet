/* 회원 정보 입력 */
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD,MEM_IMG) 
  values('관리자1','admin1@test.com','rpdlek','default.jpg');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD,MEM_IMG) 
  values('관리자2','admin2@test.com','rpdlek','default.jpg');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD,MEM_IMG) 
  values('관리자3','admin3@test.com','rpdlek','default.jpg');
insert into Member(MEM_NAME,MEM_EMAIL,MEM_PWD,MEM_IMG) 
  values('관리자4','admin4@test.com','rpdlek','default.jpg');

/* 수신함 내용 입력 */
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(1,2,'HIHI',true,now());
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(2,1,'HELLO',true,now());
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(3,2,'GAY',false,now());
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(2,4,'YO',true,now());
insert into RECEIVEBOX(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED,SEND_DATE) values(4,1,'CSS',false,now());


/* 내 펫 추가하기 */
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('1','강현찡','DOG','포메라이안','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('1','상훈찡','DOG','시베리안허스키','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('2','지호찡','FISH','자라','#FF1234');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('3','대진꽁','BIRD','앵무새','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('3','냥냥이','CAT','페르시안','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('4','갓쥐','FISH','상어','#FF1211');
insert into Pet(MEM_NUM,PET_NAME,PET_SPEC,PET_TYPE,TAG_COLOR)
  values('4','야꽐라','ETC','코알라','#123421');

  
/* 짝짓기 내용 추가 */
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~1','서울 강남역 근처로 부탁드려요~','DOG','포메라이안',true,now(),1);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~2','서울 강남역 근처로 부탁드려요~','CAT','페르시안',false,now(),1);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~3','서울 강남역 근처로 부탁드려요~','DOG','시베리안허스키',true,now(),1);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~4','서울 강남역 근처로 부탁드려요~','DOG','슈나우져',true,now(),1);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~5','서울 강남역 근처로 부탁드려요~','DOG','불독',true,now(),2);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~6','서울 강남역 근처로 부탁드려요~','CAT','집고양이',false,now(),2);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~7','우리 아이 부탁드려요~~~~','FISH','악어',true,now(),2);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~8','나이는 어려용~~~','BIRD',false,now(),3);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~9','서울 강남역 근처로 부탁드려요~','BIRD','앵무새',true,now(),3);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 짝짓기 부탁해요~~~10','서울 강남역 근처로 부탁드려요~','DOG','누렁이',true,now(),4);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 한번 하게 해주~~~11','서울 강남역 근처로 부탁드려요~','DOG','진돗개',true,now(),4);
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_SPEC,MAT_TYPE,MAT_GEN,MAT_CRE,MEM_NUM)
  values('우리 아이 한번 하게 해주~~~12','서울 강남역 근처로 부탁드려요~','CAT','냥이',true,now(),4);

  
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 1);
insert into files(FILE_NAME,MAT_NUM)
values ('h4.jpg', 1);
insert into files(FILE_NAME,MAT_NUM)
values ('h7.jpg', 1);
insert into files(FILE_NAME,MAT_NUM)
values ('a8.jpg', 1);
insert into files(FILE_NAME,MAT_NUM)
values ('h9.jpg', 2);
insert into files(FILE_NAME,MAT_NUM)
values ('h8.jpg', 2);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 2);
insert into files(FILE_NAME,MAT_NUM)
values ('h4.jpg', 3);
insert into files(FILE_NAME,MAT_NUM)
values ('h5.jpg', 3);
insert into files(FILE_NAME,MAT_NUM)
values ('h6.jpg', 3);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 4);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 5);
insert into files(FILE_NAME,MAT_NUM)
values ('h6.jpg', 5);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 6);
insert into files(FILE_NAME,MAT_NUM)
values ('h8.jpg', 6);
insert into files(FILE_NAME,MAT_NUM)
values ('h7.jpg', 6);
insert into files(FILE_NAME,MAT_NUM)
values ('a8.jpg', 7);
insert into files(FILE_NAME,MAT_NUM)
values ('a6.jpg', 8);
insert into files(FILE_NAME,MAT_NUM)
values ('a2.jpg', 8);
insert into files(FILE_NAME,MAT_NUM)
values ('h9.jpg', 9);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 9);
insert into files(FILE_NAME,MAT_NUM)
values ('h3.jpg', 10);
insert into files(FILE_NAME,MAT_NUM)
values ('h6.jpg', 10);
insert into files(FILE_NAME,MAT_NUM)
values ('h4.jpg', 10);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 11);
insert into files(FILE_NAME,MAT_NUM)
values ('h4.jpg', 11);
insert into files(FILE_NAME,MAT_NUM)
values ('h5.jpg', 11);
insert into files(FILE_NAME,MAT_NUM)
values ('h2.jpg', 12);
insert into files(FILE_NAME,MAT_NUM)
values ('h5.jpg', 12);
insert into files(FILE_NAME,MAT_NUM)
values ('h7.jpg', 12);
insert into files(FILE_NAME,MAT_NUM)
values ('h4.jpg', 12);
  

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
insert into Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR,PET_SPEC)
  values(6,4,'2016-01-01','2016-01-10','2016-01-10','주사맞자~','1차예방접종','ILJUNG','#988752','DIV03');
insert into Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR,PET_SPEC)
  values(5,3,'2016-01-01','2016-01-10','2016-01-10','예방접종','3차예방접종','ILJUNG','#120982','DIV02');
insert into Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR,PET_SPEC)
  values(2,1,'2016-01-01','2016-01-10','2016-01-10','검진받기','종합 검진 받기','ILJUNG','#123456','DIV01');
insert into Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,TAG_COLOR,PET_SPEC)
  values(3,2,'2016-01-01','2016-01-10','2016-01-10','약 받기','약받으러 병원으로','ILJUNG','#001122','DIV05');

  
/* 자랑하기 등록 */
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(4,3,'2016-01-25','2016-02-25',now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','JARANG',false,'#123098','FISH');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(2,1,'2016-01-25','2016-01-25',now(),'반해버렸어요','너무 이쁜거 있죠?','JARANG',true,'#123456','DOG');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(1,1,'2016-01-20','2016-01-20',now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','JARANG',true,'#000000','CAT');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(1,1,'2016-01-28','2016-01-28',now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','JARANG',false,'#000000','BIRD');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(3,2,'2016-01-29','2016-01-29',now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','JARANG',true,'#001122','ETC');


/* 산책코스 등록 */
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(5,3,'2016-01-20','2016-01-20',now(),'콩이랑 다녀왔어요~','너무 이쁜거 있죠? 여러분도 다녀오세요','SANCHE',false,'#120982','CAT');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(3,2,'2016-01-19','2016-01-19',now(),'반해버렸어요','너무 이쁜거 있죠?','SANCHE',true,'#001122','ETC');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(3,2,'2016-01-09','2016-01-09',now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','SANCHE',false,'#001122','DOG');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(7,4,'2016-01-11','2016-01-11',now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','SANCHE',false,'#572985','FISH');
insert into 
  Schedule(PET_NUM,MEM_NUM,START_DATE,END_DATE,SCH_CRE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_HIDE,TAG_COLOR,PET_SPEC)
  values(6,4,'2016-01-02','2016-01-02',now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','SANCHE',true,'#988752','BIRD');
  
/* Comment */
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
values('너무 이뻐요~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
values('너무 이뻐요~',3,2);
insert into Comment(CMT_CONTENT,MEM_NUM,SCH_NUM) 
values('너무 이뻐요~',4,2);

insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
  values('잘 키우고 싶네여 도움이 많이 되요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
values('너무 이뻐요~',2,2);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
  values('이런 방법이 있군요~',3,3);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
values('너무 이뻐요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
values('너무 이뻐요~',1,1);
insert into Comment(CMT_CONTENT,MEM_NUM,EDU_NUM) 
values('너무 이뻐요~',1,3);

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
  
  
  
  