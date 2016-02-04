package pms.dao;

import java.util.List;

import pms.domain.Education;

public interface EducationDao {
	List<Education> educationList(int pageNo);
	List<Education> educationSList(String eduSpec);
	List<Education> educationLast();
	
	Education count();
	
	void insert(Education education);
	
	int delete(int eduNo);
	
	int update(Education education);
	
  void addViews(int eduNo);
    
	Education selectOne(int eduNo);
}
