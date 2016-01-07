package pms.domain;

import java.io.Serializable;

/* 댓글 관리 */
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int comNo;					// 댓글 번호
	protected String comContent; 	// 댓글의 내용
	protected int mno;						// 회원 번호
	protected int dno;						// 일정 게시물 번호
	protected int eduNo;					// 교육 게시물 번호
	protected int sno;						// 분양 게시물 번호
	protected int matNo;					// 짝짓기 게시물 번호
	
	public Comment () {}

	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getEduNo() {
		return eduNo;
	}
	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
}