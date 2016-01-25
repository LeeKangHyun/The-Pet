package pms.service;

import java.util.List;

import pms.domain.Message;



public interface MessageService {
	
  List<Message> msgList(int recvMno, int pageNo);
	Message msgDetail(int msgNo);
	Message noReadMsg(int recvMno);
	int readMsg(int msgNo);
  int add(Message message);
  int remove(int msgNo);
  int removeAll(int recvMno);
  
}







