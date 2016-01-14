package pms.service;

import java.util.List;

import pms.domain.Diary;



public interface BoastBoardService {
	
  List<Diary> selectList();
  
  List<Diary> rankList();
  
  Diary selectOne(int dno);
  
}







