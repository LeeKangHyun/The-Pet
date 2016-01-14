package pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Diary  implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int dno;          // 일정번호
  protected int pno;          // 펫 번호
  protected int mno;					// 회원 번호
  protected String startDate;   // 시작일
  protected String endDate;     // 종료일
  protected Date createDate;  // 작성일
  protected String content; 	// 내용
  protected String title;   	// 제목
  protected String cateCode;  //카테고리 코드 ILJUNG=일정 JARANG=자랑하기 SANCHE=산책코스
  protected boolean dhide;    // 공개여부 0=공개 1=비공개
  protected int view;         // 조회수    default=0
  protected int like;         // 좋아요수  default=0
  protected String tagColor;  // 태그색
  protected String filename; //파일이름 (자랑하기 게시판 사용 by.JH)
  protected String member; // 회원 이름 추가(자랑하기 게시판 사용 by.JH)
  
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

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public String getTagColor() {
    return tagColor;
  }

  public void setTagColor(String tagColor) {
    this.tagColor = tagColor;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }
  
}
