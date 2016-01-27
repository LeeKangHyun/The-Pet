package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Receive;

public interface ReceiveDao {
	List<Receive> selectList(Map<String, Object> paramMap);

	Receive selectOne(int msgNo);
	
	Receive noRead(int recvMno);

	int read(int msgNo);
	
	Receive recvCount(int recvMno);
	
  int insert(Receive recive);

  int delete(int msgNo);
  
  int deleteAll(int recvMno);
}







