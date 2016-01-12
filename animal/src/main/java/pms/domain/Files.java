package pms.domain;

import java.io.Serializable;

/* 파일 관리 */
public class Files implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int fno;					// file 번호
	protected String fileName;	// file 명
	protected int eduNo;				// file이 올려진 교육 게시물 번호
	protected int matNo;				// file이 올려진 짝짓기 게시물 번호 
	protected int sno;					// file이 올려진 분양 게시물 번호
	protected int dno;					// file이 올려진 일정(자랑하기, 산책코스) 게시물 번호
	
	protected String fName;
	
	public Files () {}

	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getEduNo() {
		return eduNo;
	}
	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}
	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}

	///////////////////////////////////////////
  public String getfName() {
    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }
  ///////////////////////////////////////////
	
	
	
	
}
