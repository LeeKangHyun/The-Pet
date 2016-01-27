package pms.service;

import java.util.List;

import pms.domain.Send;



public interface SendService {
	
  List<Send> sendMsgList(int sendMno, int pageNo);
  Send msgDetail(int msgNo);
  Send sendBoxCount(int sendMno);
  int add(Send send);
  int remove(int msgNo);
  int removeAll(int recvMno);
  
}







