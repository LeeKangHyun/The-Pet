package pms.service;

import java.util.List;

import pms.domain.Education;

public interface EducationService {
	
	List<Education> getEducationList(int pageNo);
	List<Education> getEducationLast();
	
	Education getOneEducation(int eduNo);
	
	Education pages();
	
	void addViews(int eduNo);
	
	void insert(Education education);
	
	void remove(int eduNo, int mno);
	
	void change(Education education);
}
