package pms.domain;

import java.io.Serializable;
import java.sql.Date;

/* 짝짓기 관련 정보 게시판 */
public class Mating implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int matNo;						// 짝짓기 게시물 번호
	protected int memNo;						// 짝짓기 게시물 작성한 회원 번호
	protected int matViews;  			// 짝짓기 게시물 조회수
	protected Date matCre;					// 짝짓기 게시물 작성일
	protected String matTitle;			// 짝짓기 게시물 제목
	protected String matContent;  // 짝짓기 게시물 내용
	protected String matDiv;				// 애완 동물 구분 -> 개, 고양이, 물고기, 새, etc
	protected String matSpecies;	  // 애완 동물 종류 -> 포메라이안, 시베리안허스키 등등..
	protected String matSex;				// 애완 동물 성별
	protected String matCost;			// 중매금
	
	public Mating () {}

	public int getMatNo() {
		return matNo;
	}

	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getMatViews() {
		return matViews;
	}

	public void setMatViews(int matViews) {
		this.matViews = matViews;
	}

	public Date getMatCre() {
		return matCre;
	}

	public void setMatCre(Date matCre) {
		this.matCre = matCre;
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

	public String getMatDiv() {
		return matDiv;
	}

	public void setMatDiv(String matDiv) {
		this.matDiv = matDiv;
	}

	public String getMatSpecies() {
		return matSpecies;
	}

	public void setMatSpecies(String matSpecies) {
		this.matSpecies = matSpecies;
	}

	public String getMatSex() {
		return matSex;
	}

	public void setMatSex(String matSex) {
		this.matSex = matSex;
	}

	public String getMatCost() {
		return matCost;
	}

	public void setMatCost(String matCost) {
		this.matCost = matCost;
	}
}
