package pms.domain;

/* 카테고리 정리 */
public class Category {
	protected String cateCode;		// 카테고리 코드 tab001, tab002 ...
	protected String cateName;		// 카테고리 이름 자랑하기, 산책코스 ... 
	
	public Category () {}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	
}
