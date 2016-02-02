package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;
import pms.domain.Walk;

public interface WalkDao {
  int add(Walk walk);
  
  List<Walk> list(int dno);
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  List<Walk> selectName();
  
  double count();
  
  int view(Diary diary);
  
  int delete(int dno);

}
