package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.boastBoard;

public interface boastBoardDao {
  
  List<boastBoard> selectList(Map<String,Object> paramMap);
  
}







