package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Message;

public interface MessageDao {
	List<Message> selectList(Map<String, Object> paramMap);
	
	List<Message> sendList(Map<String, Object> paramMap);

	Message selectOne(int msgNo);
	
	Message noRead(int recvMno);

	int read(int msgNo);
	
  int insert(Message message);

  int delete(int msgNo);
  
  int deleteAll(int recvMno);
}







