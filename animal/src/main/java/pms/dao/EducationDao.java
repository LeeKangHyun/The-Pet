package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Education;

public interface EducationDao {
	List<Education> selectList(Map<String,Object> paramMap);
	
	List<Education> selectCate(Map<String,Object> paramMap);
	
	int insert(Education education);
	
	int delete(Map<String,Object> paramMap);
	
	int update(Education education);
	
  int addViews(int eduNo);
    
	Education selectOne(int eduNo);
}
