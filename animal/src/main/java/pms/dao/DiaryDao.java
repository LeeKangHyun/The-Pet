package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;

public interface DiaryDao {
  List<Diary> eventList(int mno);
  
  List<Diary> cateList(Map<String,Object> paramMap);
  
  Diary selectOne(int dno);
  
  int insert(Diary diary);
  
  int delete(int dno);
  
  int update(Diary diary);
}







