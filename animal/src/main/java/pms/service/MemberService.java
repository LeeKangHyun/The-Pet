package pms.service;

import java.util.List;

import pms.domain.Member;



public interface MemberService {
	
	List<Member> getMemberList();
  int register(Member member);
  int remove(int mno);
  int change(Member member);
  int change2(Member member);
  Member findNum(String mEmail);
  Member checkEmail(String mEmail);
  Member checkPwd(int mno);
  Member oneMember(int mno);
  Member login(String mEmail, String password);

}







