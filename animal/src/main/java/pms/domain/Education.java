package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 교육 관련 정보 게시판 */
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int eduNo;					// 교육 게시물 번호
	protected int mno;					// 관리자 멤버 번호
	protected int eduViews;      // 교육 게시물 조회수
	protected Date  eduCreateDate;    // 교육 게시물 작성날짜
	protected String eduTitle;   // 교육 게시물 제목
	protected String eduContent; // 교육 게시물 내용
	protected String eduSpec;     // 교육 게시물 동물 구분 -> 개, 고양이, 물고기, 새, etc
															 //                 DIV01,DIV02,DIV03,DIV04,DIV05
  protected int eduLikes;  	  // 교육 게시물 좋아요 수
	protected String attachFile;	// 컬럼명 = fileName
	protected double count;
	
	public int getEduLikes() {
		return eduLikes;
	}

	public void setEduLikes(int eduLikes) {
		this.eduLikes = eduLikes;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public Education () {}

	public int getEduNo() {
		return eduNo;
	}
	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getEduViews() {
		return eduViews;
	}
	public void setEduViews(int eduViews) {
		this.eduViews = eduViews;
	}
	public Date getEduCreateDate() {
		return eduCreateDate;
	}
	public void setEduCreateDate(Date eduCreateDate) {
		this.eduCreateDate = eduCreateDate;
	}
	public String getEduTitle() {
		return eduTitle;
	}
	public void setEduTitle(String eduTitle) {
		this.eduTitle = eduTitle;
	}
	public String getEduContent() {
		return eduContent;
	}
	public void setEduContent(String eduContent) {
		this.eduContent = eduContent;
	}

	public String getEduSpec() {
		return eduSpec;
	}

	public void setEduSpec(String eduSpec) {
		this.eduSpec = eduSpec;
	}


}
