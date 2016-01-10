package pms.service;

import java.util.List;

import pms.domain.Diary;

public interface BoastBoardService {
	
  List<Diary> selectList();
  
  Diary selectOne(int dno);
  
}







