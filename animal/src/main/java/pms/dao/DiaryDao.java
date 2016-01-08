package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;

public interface DiaryDao {
  List<Diary> eventList();
  
  List<Diary> selectList(Map<String,Object> paramMap);
  
  int insert(Diary diary);
  
  int delete(int dno);
  
  int update(Diary diary);
}







