package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.SendDao;
import pms.domain.Send;
import pms.service.SendService;

@Service
public class DefaultSendService implements SendService {
	
	@Autowired SendDao sendDao;
	
	public List<Send> sendMsgList(int sendMno, int pageNo) {
		HashMap<String, Object> paramMap = new HashMap<>();
	  paramMap.put("startIndex", (pageNo - 1) * 15);
	  paramMap.put("sendMno", sendMno);
	  
		return sendDao.sendList(paramMap);
  }
	
	public Send msgDetail(int msgNo) {
		return sendDao.selectOne(msgNo);
	}
	
	public Send sendBoxCount(int sendMno) {
		return sendDao.sendCount(sendMno);
	}
	
  public int add(Send send) {
  	return sendDao.insert(send);
  }

  public int remove(int msgNo) {
  	return sendDao.delete(msgNo);
  }

  public int removeAll(int recvMno) {
  	return sendDao.deleteAll(recvMno);
  }

}