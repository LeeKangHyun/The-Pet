package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Member;

public interface MemberDao {
	List<Member> selectList();

  int insert(Member member);

  int delete(String mEmail);
  
  int update(Member member);

  Member selectOne(String mEmail);

  Member selectOneByEmailPassword(Map<String,Object> paramMap);
}







