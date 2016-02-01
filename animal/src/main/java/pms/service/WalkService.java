package pms.service;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;
import pms.domain.Walk;

public interface WalkService {
  int add(Walk walk);
  
  List<Walk> list(int sno);
  
  List<Diary> selectList(Map<String, Object> paramMap);

}
