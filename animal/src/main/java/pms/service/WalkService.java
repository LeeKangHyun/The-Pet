package pms.service;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;
import pms.domain.Walk;

public interface WalkService {
  int add(Walk walk);
  
  List<Walk> list(int dno);
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  List<Walk> selectName();
  
  public Double count();

  int view(Diary diary);
  
  int remove(int dno);
}
