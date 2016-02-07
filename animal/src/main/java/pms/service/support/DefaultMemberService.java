package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.MemberDao;
import pms.domain.Member;
import pms.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {
	
	@Autowired MemberDao memberDao;
	
	public List<Member> getMemberList() {
		return memberDao.selectList();
  }

  public int register(Member member) {
  	return memberDao.insert(member);
  }

  public int remove(int mno) {
  	return memberDao.delete(mno);
  }
  
  public int change(Member member) {
  	return memberDao.update(member);
  }

  public Member findNum(String mEmail) {
  	return memberDao.findMno(mEmail);
  }
  
  public Member checkEmail(String mEmail) {
  	return memberDao.selectEmail(mEmail);
  }
  
  public Member checkPwd(int mno) {
    return memberDao.selectPwd(mno);
  }
  
  public Member oneMember(int mno) {
  	return memberDao.selectOne(mno);
  }

  public Member login(String mEmail, String password) {
  	HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mEmail", mEmail);
    paramMap.put("password", password);
    
  	return memberDao.selectOneByEmailPassword(paramMap);
  }

}