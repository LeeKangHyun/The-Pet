package pms.domain;

import java.io.Serializable;

/* 쪽지 정보 */
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int msgNo;					 // 쪽지 번호
	protected int sendMno;     // 보내는 멤버 번호
	protected int recvMno;  // 받는 멤버 번호
	protected String msgContent; // 쪽지 내용
	protected boolean msgChecked; // 쪽지 확인 여부 -> 읽지 않으면 true, 읽으면 false
	
	public Message () {}

	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public int getSendMno() {
		return sendMno;
	}
	public void setSendMno(int sendMno) {
		this.sendMno = sendMno;
	}
	public int getRecvMno() {
		return recvMno;
	}
	public void setRecvMno(int recvMno) {
		this.recvMno = recvMno;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public boolean isMsgChecked() {
		return msgChecked;
	}
	public void setMsgChecked(boolean msgChecked) {
		this.msgChecked = msgChecked;
	}
}
