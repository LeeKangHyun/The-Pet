package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 쪽지 정보 */
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int msgNo;					// 쪽지 번호
	protected int sendMno;    		// 보내는 멤버 번호
	protected int recvMno;				// 받는 멤버 번호
	protected String msgContent;	// 쪽지 내용
	protected boolean msgChecked; // 쪽지 확인 여부 -> 읽지 않으면 false(0), 읽으면 true(1)
	protected Date msgCreateDate;
	protected int noReadCount;
	
	public Message () {}
	

	public int getNoReadCount() {
		return noReadCount;
	}
	public void setNoReadCount(int noReadCount) {
		this.noReadCount = noReadCount;
	}
	public Date getMsgCreateDate() {
		return msgCreateDate;
	}
	public void setMsgCreateDate(Date msgCreateDate) {
		this.msgCreateDate = msgCreateDate;
	}
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
