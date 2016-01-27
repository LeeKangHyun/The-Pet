package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.ReceiveDao;
import pms.domain.Receive;
import pms.service.ReceiveService;

@Service
public class DefaultReceiveService implements ReceiveService {
	
	@Autowired ReceiveDao reciveDao;
	
	public List<Receive> msgList(int recvMno, int pageNo) {
		HashMap<String, Object> paramMap = new HashMap<>();
	  paramMap.put("startIndex", (pageNo - 1) * 15);
	  paramMap.put("recvMno", recvMno);
	  
		return reciveDao.selectList(paramMap);
  }
	
	public Receive recvBoxCount(int recvMno) {
		return reciveDao.recvCount(recvMno);
	}
	
	public Receive msgDetail(int msgNo) {
		return reciveDao.selectOne(msgNo);
	}
	
	public Receive noReadMsg(int recvMno) {
		return reciveDao.noRead(recvMno);
	}
	
	public int readMsg(int msgNo) {
		return reciveDao.read(msgNo);
	}

  public int add(Receive message) {
  	return reciveDao.insert(message);
  }

  public int remove(int msgNo) {
  	return reciveDao.delete(msgNo);
  }

  public int removeAll(int recvMno) {
  	return reciveDao.deleteAll(recvMno);
  }

}