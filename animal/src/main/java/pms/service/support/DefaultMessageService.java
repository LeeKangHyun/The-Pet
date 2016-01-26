package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.MessageDao;
import pms.domain.Message;
import pms.service.MessageService;

@Service
public class DefaultMessageService implements MessageService {
	
	@Autowired MessageDao messageDao;
	
	public List<Message> msgList(int recvMno, int pageNo) {
		HashMap<String, Object> paramMap = new HashMap<>();
	  paramMap.put("startIndex", (pageNo - 1) * 15);
	  paramMap.put("recvMno", recvMno);
	  
		return messageDao.selectList(paramMap);
  }
	
	public List<Message> sendMsgList(int sendMno, int pageNo) {
		HashMap<String, Object> paramMap = new HashMap<>();
	  paramMap.put("startIndex", (pageNo - 1) * 15);
	  paramMap.put("sendMno", sendMno);
	  
		return messageDao.sendList(paramMap);
  }
	
	public Message msgDetail(int msgNo) {
		return messageDao.selectOne(msgNo);
	}
	
	public Message noReadMsg(int recvMno) {
		return messageDao.noRead(recvMno);
	}
	
	public int readMsg(int msgNo) {
		return messageDao.read(msgNo);
	}

  public int add(Message message) {
  	return messageDao.insert(message);
  }

  public int remove(int msgNo) {
  	return messageDao.delete(msgNo);
  }

  public int removeAll(int recvMno) {
  	return messageDao.deleteAll(recvMno);
  }

}