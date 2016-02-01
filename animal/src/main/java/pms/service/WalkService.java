package pms.service;

import java.util.List;
import java.util.Map;

import pms.domain.Walk;

public interface WalkService {
  int add(Walk walk);
  
  List<Walk> list(int sno);
  
  List<Walk> selectList(Map<String, Object> paramMap);

}
