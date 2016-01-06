package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 산책 코스 게시판 */
public class Walking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int schNo;						// 일정 번호
 	protected int pNo; 						// 펫 번호
	protected String cateCode;			// 카테고리 코드 -> 산책 코스는 tab002
	protected Date startDate;			// 일정 시작일
	protected Date endDate;				// 일정 종료일
	protected Date schCre;					// 일정 등록일
	protected String schTitle;			// 일정 제목
	protected String schContent;		// 일정 내용
	protected int notiHide;				// 공개 여부 -> 0은 공개, 1은 비공개
	protected int notiViews;				// 일정 조회수
	protected int notiLikes;				// 일정 좋아요 수
	
	public Walking () {}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
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

	public Date getSchCre() {
		return schCre;
	}

	public void setSchCre(Date schCre) {
		this.schCre = schCre;
	}

	public String getSchTitle() {
		return schTitle;
	}

	public void setSchTitle(String schTitle) {
		this.schTitle = schTitle;
	}

	public String getSchContent() {
		return schContent;
	}

	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}

	public int getNotiHide() {
		return notiHide;
	}

	public void setNotiHide(int notiHide) {
		this.notiHide = notiHide;
	}

	public int getNotiViews() {
		return notiViews;
	}

	public void setNotiViews(int notiViews) {
		this.notiViews = notiViews;
	}

	public int getNotiLikes() {
		return notiLikes;
	}

	public void setNotiLikes(int notiLikes) {
		this.notiLikes = notiLikes;
	}
}
