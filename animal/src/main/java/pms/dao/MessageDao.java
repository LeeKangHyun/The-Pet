package pms.dao;

import java.util.List;

import pms.domain.Message;

public interface MessageDao {
	List<Message> selectList(int recvMno);

	Message selectOne(int msgNo);

  int insert(Message message);

  int delete(int msgNo);
  
  int deleteAll(int recvMno);
}







