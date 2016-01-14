package pms.dao;

import java.util.List;

import pms.domain.Diary;

public interface BoastBoardDao {
  
  List<Diary> selectList();
  
  List<Diary> rankList();
  
  Diary selectOne(int dno);
  
}







