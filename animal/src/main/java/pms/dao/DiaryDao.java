package pms.dao;

import java.util.List;

import pms.domain.Diary;

public interface DiaryDao {
  List<Diary> eventList();
  
  List<Diary> petList(int mno);
  
  int insert(Diary diary);
  
  int delete(int dno);
  
  int update(Diary diary);
}







