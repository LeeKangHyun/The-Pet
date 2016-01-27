package pms.service;

import java.util.List;

import pms.domain.Receive;



public interface ReceiveService {
	
  List<Receive> msgList(int recvMno, int pageNo);
	Receive msgDetail(int msgNo);
	Receive noReadMsg(int recvMno);
	int readMsg(int msgNo);
	Receive recvBoxCount(int recvMno);
  int add(Receive message);
  int remove(int msgNo);
  int removeAll(int recvMno);
  
}







