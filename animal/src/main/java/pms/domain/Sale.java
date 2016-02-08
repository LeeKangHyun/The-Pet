package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 짝짓기 관련 정보 게시판 */
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int sno;						// 분양 게시물 번호
	protected int mno;							// 분양 게시물 작성한 회원 번호
	protected int sViews;  				// 분양 게시물 조회수  default:0
	protected Date sCreateDate;		// 분양 게시물 작성일
	protected String sTitle;			// 분양 게시물 제목
	protected String sContent;  	// 분양 게시물 내용
	protected String sSpec;				// 애완 동물 구분 코드 -> 개, 고양이, 물고기, 새,  etc
																	//                 	DOG, CAT, FISH, BIRD,ETC
	protected String sType;	  		// 애완 동물 종류 -> 포메라이안, 시베리안허스키 등등..
	protected boolean sGender;		// 애완 동물 성별   남: false 0  	여: true 1
	protected int sCost;					// 중매금
	protected double count;
	protected String filename;
	protected String mname;
	protected String memail;
	protected String mimg;
	
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

	public int getsViews() {
		return sViews;
	}

	public void setsViews(int sViews) {
		this.sViews = sViews;
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

	public boolean issGender() {
		return sGender;
	}

	public void setsGender(boolean sGender) {
		this.sGender = sGender;
	}

	public int getsCost() {
		return sCost;
	}

	public void setsCost(int sCost) {
		this.sCost = sCost;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	
	
}
