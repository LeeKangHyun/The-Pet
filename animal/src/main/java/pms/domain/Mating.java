package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 짝짓기 관련 정보 게시판 */
public class Mating implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int matNo;						// 짝짓기 게시물 번호
	protected int mno;						// 짝짓기 게시물 작성한 회원 번호
	protected int matViews;  			// 짝짓기 게시물 조회수
	protected Date matCreateDate;					// 짝짓기 게시물 작성일
	protected String matTitle;			// 짝짓기 게시물 제목
	protected String matContent;  // 짝짓기 게시물 내용
	protected String matSpec;				// 애완 동물 구분 -> 개, 고양이, 물고기, 새, etc
	protected String matType;	  // 애완 동물 종류 -> 포메라이안, 시베리안허스키 등등..
	protected String matGender;				// 애완 동물 성별
	protected String matCost;			// 중매금
	
	public Mating () {}

	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getMatViews() {
		return matViews;
	}
	public void setMatViews(int matViews) {
		this.matViews = matViews;
	}
	public Date getMatCreateDate() {
		return matCreateDate;
	}
	public void setMatCreateDate(Date matCreateDate) {
		this.matCreateDate = matCreateDate;
	}
	public String getMatTitle() {
		return matTitle;
	}
	public void setMatTitle(String matTitle) {
		this.matTitle = matTitle;
	}
	public String getMatContent() {
		return matContent;
	}
	public void setMatContent(String matContent) {
		this.matContent = matContent;
	}
	public String getMatSpec() {
		return matSpec;
	}
	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
	public String getMatType() {
		return matType;
	}
	public void setMatType(String matType) {
		this.matType = matType;
	}
	public String getMatGender() {
		return matGender;
	}
	public void setMatGender(String matGender) {
		this.matGender = matGender;
	}
	public String getMatCost() {
		return matCost;
	}
	public void setMatCost(String matCost) {
		this.matCost = matCost;
	}
}
