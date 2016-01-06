package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 분양 정보 게시판 */
public class ParcelOut implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int poNo;					// 분양 게시물 번호
	protected int memNo;					// 분양 게시물 작성한 회원 번호
	protected Date poCre;  			// 분양 게시물 작성일
	protected String poTitle;		// 분양 게시물 제목
	protected String poContent;  // 분양 게시물 내용
	protected String poDiv;			// 분양할 동물 구분 -> 개, 고양이, 물고기, 새, etc
	protected String poSpecies;  // 분양할 동물 종류 -> 포메라이안, 시베리안허스키 등등..
	protected String poCost;			// 판매금
	
	public ParcelOut () {}

	public int getPoNo() {
		return poNo;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public Date getPoCre() {
		return poCre;
	}

	public void setPoCre(Date poCre) {
		this.poCre = poCre;
	}

	public String getPoTitle() {
		return poTitle;
	}

	public void setPoTitle(String poTitle) {
		this.poTitle = poTitle;
	}

	public String getPoContent() {
		return poContent;
	}

	public void setPoContent(String poContent) {
		this.poContent = poContent;
	}

	public String getPoDiv() {
		return poDiv;
	}

	public void setPoDiv(String poDiv) {
		this.poDiv = poDiv;
	}

	public String getPoSpecies() {
		return poSpecies;
	}

	public void setPoSpecies(String poSpecies) {
		this.poSpecies = poSpecies;
	}

	public String getPoCost() {
		return poCost;
	}

	public void setPoCost(String poCost) {
		this.poCost = poCost;
	}
}
