package pms.domain;

import java.io.Serializable;

/* 회원 정보 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int memNo; 			 // 회원 번호
	protected String memName;  // 회원 이름
	protected String memEmail; // 회원 이메일
	protected String password; // 회원 비밀번호
	protected String tel; 			 // 회원 전화번호
	protected String memImg;		 // 회원 이미지 정보
	
	public Member() {}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
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

	public String getMemImg() {
		return memImg;
	}

	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}
	
	
}
