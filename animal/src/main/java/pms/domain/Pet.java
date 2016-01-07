package pms.domain;

import java.io.Serializable;

/* 내 펫 등록 */
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int pno; 					// 펫 번호
	protected int mno; 					// 회원 번호
	protected String pName; 			// 펫 이름
	protected String pType; 			// 펫 종 -> 포메라이안, 시베리안 허스키 등등..
	protected String pImg; 			// 펫 이미지
	protected String tagColor; 	// 태그 색 ex)#010203 형식으로 
	protected String injection; // 주사 일정 관련
	protected String medicine; 	// 약 일정 관련
	
	public Pet() {}

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
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getTagColor() {
		return tagColor;
	}
	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}
	public String getInjection() {
		return injection;
	}
	public void setInjection(String injection) {
		this.injection = injection;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}	
}
