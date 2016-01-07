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
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(3,2,'GAY');
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(2,4,'YO');
insert into Message(MEM_NUM,MEM_NUM2,MSG_CONTENT,CHECKED) values(4,1,'CSS');

/* 교육 내용 입력 */
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('포메라이안 교육','교육이다아아앙1','개');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('냐옹이 교육','교육이다아아앙2','고양이');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('송사리 교육','교육이다아아앙3','물고기');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('상어 교육','교육이다아아앙4','물고기');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('앵무새 교육','교육이다아아앙5','새');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('악어 교육','교육이다아아앙6','ETC');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('타조 교육','교육이다아아앙7','새');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('시베리안 허스키 교육','교육이다아아앙8','개');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('페르시안 교육','교육이다아아앙9','고양이');
insert into Education(EDU_TITLE,EDU_CONTENT,EDU_DIV)
  values('터키 앙고라 교육','교육이다아아앙10','고양이');

/* 내 펫 추가하기 */
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('1','강현찡','포메라이안','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('1','상훈찡','시베리안허스키','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('2','지호찡','자라','#FF1234');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('3','대진꽁','거북이','#FF1122');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('3','냥냥이','크로크다일','#FF0000');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('4','갓쥐','이구아나','#FF1211');
insert into Pet(MEM_NUM,PET_NAME,PET_SPECIES,TAG_COLOR)
  values('4','야꽐라','코알라','#123421');

  
/* 짝짓기 내용 추가 */
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~1','서울 강남역 근처로 부탁드려요~','개','포메라이안','여자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~2','서울 강남역 근처로 부탁드려요~','고양이','페르시안','남자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~3','서울 강남역 근처로 부탁드려요~','개','시베리안허스키','여자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~4','서울 강남역 근처로 부탁드려요~','개','슈나우져','여자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~5','서울 강남역 근처로 부탁드려요~','개','불독','여자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~6','서울 강남역 근처로 부탁드려요~','고양이','집고양이','남자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~7','우리 아이 부탁드려요~~~~','ETC','악어','여자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~8','나이는 어려용~~~','새','비둘기','남자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~9','서울 강남역 근처로 부탁드려요~','새','앵무새','남자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 짝짓기 부탁해요~~~10','서울 강남역 근처로 부탁드려요~','개','누렁이','남자');
insert into Mating(MAT_TITLE,MAT_CONTENT,MAT_DIV,MAT_SPECIES,MAT_SEX)
  values('우리 아이 한번 하게 해주~~~11','서울 강남역 근처로 부탁드려요~','개','진돗개','남자');

/* 분양 글쓰기 */
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES)
  values('퓨마 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','퓨마');
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES)
  values('콩이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','개','시츄');
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES)
  values('츄롤리 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','거북이');
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES)
  values('꽐라 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','코알라');
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES)
  values('꽁양이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','새','앵무새');
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES,MEM_NUM)
  values('퓨마 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','퓨마',1);
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES,MEM_NUM)
  values('콩이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','개','시츄',2);
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES,MEM_NUM)
  values('츄롤리 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','거북이',2);
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES,MEM_NUM)
  values('꽐라 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','ETC','코알라',3);
insert into Parcel_Out(PO_TITLE,PO_CONTENT,PO_DIV,PO_SPECIES,MEM_NUM)
  values('꽁양이 분양해드려요~~','급한 사정이 있어 빠른 분양 부탁드려요ㅠㅠ','새','앵무새',4);
  
  
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
insert into Comment(CMT_CONTENT,MEM_NUM,PO_NUM) 
  values('너무 분양 받고 싶어요~~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,PO_NUM) 
  values('죄송해요 분양이 끝났어요~',2,2);
insert into Comment(CMT_CONTENT,MEM_NUM,PO_NUM) 
  values('너무 아쉽네~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,PO_NUM) 
  values('이쁜 아이 데려가고 싶네요~',3,1);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('저희 아가랑 짝짓기 하실래요?',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('네 ~ 좋아요~',1,2);
insert into Comment(CMT_CONTENT,MEM_NUM,MAT_NUM) 
  values('꽐라꽐라~~~~',3,9);
  
  
/* 카테고리 명 등록 */
insert into Category(CATE_CODE,CATE_NAME) values('tab001','자랑하기');
insert into Category(CATE_CODE,CATE_NAME) values('tab002','산책코스');

/* 일정등록 */
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,NOTI_OPEN)
  values(6,'2016-01-01','2016-01-10','2016-01-10',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,NOTI_OPEN)
  values(5,'2016-01-01','2016-01-10','2016-01-10',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,NOTI_OPEN)
  values(2,'2016-01-01','2016-01-10','2016-01-10',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_CRE,NOTI_OPEN)
  values(3,'2016-01-01','2016-01-10','2016-01-10',0);
  
/* 자랑하기 등록 */
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(4,now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','tab001',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(2,now(),now(),'반해버렸어요','너무 이쁜거 있죠?','tab001',1);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(1,now(),now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','tab001',1);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(1,now(),now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','tab001',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(3,now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','tab001',1);

/* 산책코스 등록 */
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(5,now(),now(),'콩이랑 다녀왔어요~','너무 이쁜거 있죠? 여러분도 다녀오세요','tab002',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(3,now(),now(),'반해버렸어요','너무 이쁜거 있죠?','tab002',1);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(3,now(),now(),'너무 이쁘죠~~?','얄라리 얄라 얄라리얄라','tab002',1);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(7,now(),now(),'심쿵해~~~~~','제 말을 너무 잘 들어요~','tab002',0);
insert into Schedule(PET_NUM,START_DATE,END_DATE,SCH_TITLE,SCH_CONTENT,CATE_CODE,NOTI_OPEN)
  values(6,now(),now(),'너무 이쁘죠~~?','제 말을 너무 잘 들어요~','tab002',1);