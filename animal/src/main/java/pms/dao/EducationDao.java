package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Education;

public interface EducationDao {
	List<Education> selectList(Map<String,Object> paramMap);
	
	//List<Education> 
	
	int insert(Education education);
	
	int delete(int eduNo, int mno);
	
	int update(Education education);
	
	Education selectOne(int eduNo);
	
}
