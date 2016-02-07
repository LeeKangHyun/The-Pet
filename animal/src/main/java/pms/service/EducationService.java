package pms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pms.domain.Education;
import pms.domain.Likes;

public interface EducationService {
	
	List<Education> getEducationList(int pageNo);
	List<Education> getEducationSList(HashMap<String,Object> educationMap);
	List<Education> getEducationLast();
	
	Education getOneEducation(int eduNo);
	
	Education pages();
	
	void addViews(int eduNo);
	
	void insert(Education education);
	
	void addLikes(int eduNo);
	
	void deleteLikes(int eduNo);
	
	int remove(int eduNo);
	
	int change(Education education);
	
	int like_add(Map<String, Object> paramMap);
	
	int like_delete(Map<String, Object> paramMap);
	
	int like_select(int like_eno);
	
	Likes like_check(Map<String, Object> paramMap);
	
	double filterCount(Map<String, Object> paramMap);
	
	double filter_list(Map<String, Object> paramMap);
	
}
