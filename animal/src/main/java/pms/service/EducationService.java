package pms.service;

import java.util.List;

import pms.domain.Education;

public interface EducationService {
	
	List<Education> getEducationList(int pageNo, int pageSize,
			String keyword, String align);
	
	List<Education> getEducationCate(int pageNo, int pageSize,
			String keyword, String align, String key);
	
	Education getOneEducation(int eduNo);
	
	void add(Education education);
	
	void remove(int eduNo, int mno);
	
	void change(Education education);
}
