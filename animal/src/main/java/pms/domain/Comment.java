package pms.domain;

import java.io.Serializable;

/* 댓글 관리 */
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int comNo;					// 댓글 번호
	protected String comComment; 	// 댓글의 내용
	protected String comImg; 			// 댓글의 이미지
	protected int mno;						// 회원 번호
	protected int dno;						// 일정 게시물 번호
	protected int eduNo;					// 교육 게시물 번호
	protected int sno;						// 분양 게시물 번호
	protected int matNo;					// 짝짓기 게시물 번호
	
	protected double count;
	
	public Comment () {}

	
	public String getComImg() {
		return comImg;
	}
	public void setComImg(String comImg) {
		this.comImg = comImg;
	}
	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public String getComComment() {
		return comComment;
	}
	public void setComComment(String comComment) {
		this.comComment = comComment;
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


  public double getCount() {
    return count;
  }


  public void setCount(double count) {
    this.count = count;
  }
	
}
