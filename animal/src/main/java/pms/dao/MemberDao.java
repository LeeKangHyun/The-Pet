package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Member;

public interface MemberDao {
	List<Member> selectList();

  int insert(Member member);

  int delete(int mno);
  
  int update(Member member);

  Member selectOne(int mno);

  Member selectOneByEmailPassword(Map<String,Object> paramMap);
}







