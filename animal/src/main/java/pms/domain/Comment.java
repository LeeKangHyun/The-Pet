package pms.domain;

import java.io.Serializable;

/* 댓글 관리 */
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int cmtNo;					// 댓글 번호
	protected int memNo;					// 댓글을 작성한 회원 번호
	protected int schNo;					// 댓글이 달린 일정 게시물 번호
	protected int eduNo;					// 댓글이 달린 교육 게시물 번호
	protected int poNo;					// 댓글이 달린 분양 게시물 번호
	protected int matNo;					// 댓글이 달린 짝짓기 게시물 번호
	protected String cmtContent; // 댓글의 내용
	
	public Comment () {}

	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getSchNo() {
		return schNo;
	}

	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}

	public int getEduNo() {
		return eduNo;
	}

	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}

	public int getPoNo() {
		return poNo;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public int getMatNo() {
		return matNo;
	}

	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
}
