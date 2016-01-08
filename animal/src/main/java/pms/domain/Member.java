package pms.domain;

import java.io.Serializable;

/* 회원 정보 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int mno; 			 // 회원 번호
	protected String mName;  // 회원 이름
	protected String mEmail; // 회원 이메일
	protected String password; // 회원 비밀번호
	protected String tel; 			 // 회원 전화번호
	protected String mImg;		 // 회원 이미지 정보
	
	protected Education education; // 교육 테이블 참조.
	public Member() {}

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getmImg() {
		return mImg;
	}
	public void setmImg(String mImg) {
		this.mImg = mImg;
	}
		
}
