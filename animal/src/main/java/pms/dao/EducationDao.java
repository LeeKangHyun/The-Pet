package pms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pms.domain.Education;
import pms.domain.Likes;

public interface EducationDao {
	List<Education> educationList(int pageNo);
	List<Education> educationSList(HashMap<String,Object> educationMap);
	List<Education> educationLast();
	
	Education count();
	
	void insert(Education education);
	
	int delete(int eduNo);
	
	int update(Education education);
	
  void addViews(int eduNo);
    
	Education selectOne(int eduNo);
	
	void addLikes(int eduNo);
	
	void deleteLikes(int eduNo);
	
	int like_add(Map<String, Object> paramMap);
	
	int like_delete(Map<String, Object> paramMap);
	
	int like_select(int like_eno);
	
  public Likes like_check(Map<String, Object> paramMap);

  double filterCount(Map<String, Object> paramMap);
  
  List<Education> filter_list(Map<String, Object> paramMap);
  
}
