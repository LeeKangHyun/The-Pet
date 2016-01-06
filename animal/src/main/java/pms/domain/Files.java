package pms.domain;

import java.io.Serializable;

/* 파일 관리 */
public class Files implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int fileNo;				// file 번호
	protected String fileName;		// file 명
	protected int eduNo;					// file이 올려진 교육 게시물 번호
	protected int matNo;					// file이 올려진 짝짓기 게시물 번호 
	protected int poNo;					// file이 올려진 분양 게시물 번호
	protected int schNo;					// file이 올려진 일정(자랑하기, 산책코스) 게시물 번호
	
	public Files () {}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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

	public int getPoNo() {
		return poNo;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}
}
