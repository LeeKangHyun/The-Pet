package pms.service;

import java.util.List;

import pms.domain.Diary;



public interface BoastBoardService {
	
  List<Diary> selectList(int pageNo, int pageSize);
  
  double count();
  
  List<Diary> rankList();
  
  Diary selectOne(int dno);
  
  List<Diary> searchList(int pageNo, int pageSize, Diary diary);
  
  double search_title_Count(Diary diary);
  
  double search_member_Count(Diary diary);
}







