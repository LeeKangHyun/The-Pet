package pms.service;

import java.util.List;

import pms.domain.Member;



public interface MemberService {
	
	List<Member> getMemberList();
  void register(Member member);
  int remove(int mno);
  int change(Member member);
  Member oneMember(int mno);
  Member login(String mEmail, String password);

}







