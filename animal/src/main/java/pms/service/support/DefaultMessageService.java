package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.MessageDao;
import pms.domain.Message;
import pms.service.MessageService;

@Service
public class DefaultMessageService implements MessageService {
	
	@Autowired MessageDao messageDao;
	
	public List<Message> msgList(int recvMno) {
		return messageDao.selectList(recvMno);
  }
	
	public Message msgDetail(int msgNo) {
		return messageDao.selectOne(msgNo);
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