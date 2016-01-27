package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Send;

public interface SendDao {
	
	List<Send> sendList(Map<String, Object> paramMap);

	Send selectOne(int msgNo);
	
	Send sendCount(int sendMno);
	
  int insert(Send send);

  int delete(int msgNo);
  
  int deleteAll(int sendMno);
}







