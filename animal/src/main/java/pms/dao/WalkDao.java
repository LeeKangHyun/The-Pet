package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Walk;

public interface WalkDao {
  int add(Walk walk);
  
  List<Walk> list(int mno);
  
  List<Walk> selectList(Map<String, Object> paramMap);
  
}
