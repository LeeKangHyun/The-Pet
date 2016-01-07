package pms.service;

import java.util.List;

import pms.domain.Member;



public interface MemberService {
	
	List<Member> getStudentList();
  void register(Member member);
  int remove(String mEmail);
  int change(Member member);
  Member oneMember(String mEmail);
  Member login(String mEmail, String password);

}







