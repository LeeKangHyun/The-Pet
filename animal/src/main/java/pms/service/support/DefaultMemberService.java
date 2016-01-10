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

  public void register(Member member) {
  	memberDao.insert(member);
  }

  public int remove(String mEmail) {
  	return memberDao.delete(mEmail);
  }
  
  public int change(Member member) {
  	return memberDao.update(member);
  }

  public Member oneMember(String mEmail) {
  	return memberDao.selectOne(mEmail);
  }

  public Member login(String mEmail, String password) {
  	HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mEmail", mEmail);
    paramMap.put("password", password);
    
  	return memberDao.selectOneByEmailPassword(paramMap);
  }

}