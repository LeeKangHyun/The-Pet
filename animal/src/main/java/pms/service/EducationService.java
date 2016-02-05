package pms.service;

import java.util.HashMap;
import java.util.List;

import pms.domain.Education;

public interface EducationService {
	
	List<Education> getEducationList(int pageNo);
	List<Education> getEducationSList(HashMap<String,Object> educationMap);
	List<Education> getEducationLast();
	
	Education getOneEducation(int eduNo);
	
	Education pages();
	
	void addViews(int eduNo);
	
	void insert(Education education);
	
	int remove(int eduNo);
	
	int change(Education education);
}
