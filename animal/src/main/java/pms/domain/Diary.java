package pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Diary  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int dno;					// 일정번호
  protected int pno;					// 펫 번호
  protected Date startDate;	// 시작일
  protected Date endDate;		// 종료일
  protected Date createDate;	// 작성일
  protected String content;	// 내용
  protected String title;		// 제목
  protected String cateCode;	//카테고리 코드 ILJUNG=일정 JARANG=자랑하기 SANCHE=산책코스
  protected boolean dhide;		// 공개여부	0=공개 1=비공개
  protected int view;				// 조회수    default=0
  protected int like;				// 좋아요수  default=0
  
  public Diary() {}

	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	
	public boolean isDhide() {
		return dhide;
	}

	public void setDhide(boolean dhide) {
		this.dhide = dhide;
	}

	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
  
  
}
