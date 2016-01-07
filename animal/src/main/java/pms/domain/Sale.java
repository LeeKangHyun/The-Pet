package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 분양 정보 게시판 */
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int sno;					// 분양 게시물 번호
	protected int mno;					// 분양 게시물 작성한 회원 번호
	protected Date sCreateDate; // 분양 게시물 작성일
	protected String sTitle;		// 분양 게시물 제목
	protected String sContent;  // 분양 게시물 내용
	protected String sSpec;			// 분양할 동물 구분 -> 개, 고양이, 물고기, 새, etc
	protected String sType;  		// 분양할 동물 종류 -> 포메라이안, 시베리안허스키 등등..
	protected String sCost;			// 판매금
	
	public Sale () {}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public Date getsCreateDate() {
		return sCreateDate;
	}
	public void setsCreateDate(Date sCreateDate) {
		this.sCreateDate = sCreateDate;
	}
	public String getsTitle() {
		return sTitle;
	}
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	public String getsContent() {
		return sContent;
	}
	public void setsContent(String sContent) {
		this.sContent = sContent;
	}
	public String getsSpec() {
		return sSpec;
	}
	public void setsSpec(String sSpec) {
		this.sSpec = sSpec;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public String getsCost() {
		return sCost;
	}
	public void setsCost(String sCost) {
		this.sCost = sCost;
	}
}
