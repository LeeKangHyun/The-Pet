package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 교육 관련 정보 게시판 */
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int eduNo;					// 교육 게시물 번호
	protected int memNo;					// 관리자 멤버 번호
	protected int eduViews;      // 교육 게시물 조회수
	protected Date  eduCreDt;    // 교육 게시물 작성날짜
	protected String eduTitle;   // 교육 게시물 제목
	protected String eduContent; // 교육 게시물 내용
	protected String eduDiv;     // 교육 게시물 동물 구분 -> 개, 고양이, 물고기, 새, etc
	
	public Education () {}

	public int getEduNo() {
		return eduNo;
	}

	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getEduViews() {
		return eduViews;
	}

	public void setEduViews(int eduViews) {
		this.eduViews = eduViews;
	}

	public Date getEduCreDt() {
		return eduCreDt;
	}

	public void setEduCreDt(Date eduCreDt) {
		this.eduCreDt = eduCreDt;
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

	public String getEduDiv() {
		return eduDiv;
	}

	public void setEduDiv(String eduDiv) {
		this.eduDiv = eduDiv;
	}
}
