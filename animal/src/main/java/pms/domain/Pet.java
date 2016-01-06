package pms.domain;

import java.io.Serializable;

/* 내 펫 등록 */
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int pNo; // 펫 번호
	protected int memNo; // 회원 번호
	protected String pName; // 펫 이름
	protected String pSpecies; // 펫 종 -> 포메라이안, 시베리안 허스키 등등..
	protected String pImg; // 펫 이미지
	protected String tagColor; // 태그 색
	protected String injection; // 주사 일정 관련
	protected String medicine; // 약 일정 관련
	
	public Pet() {}
	
	
	public int getpNo() {
		return pNo;
	}


	public void setpNo(int pNo) {
		this.pNo = pNo;
	}


	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpSpecies() {
		return pSpecies;
	}
	public void setpSpecies(String pSpecies) {
		this.pSpecies = pSpecies;
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
