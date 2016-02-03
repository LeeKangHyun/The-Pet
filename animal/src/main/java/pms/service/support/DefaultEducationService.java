package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.EducationDao;
import pms.domain.Education;
import pms.service.EducationService;

@Service
public class DefaultEducationService implements EducationService {

	@Autowired EducationDao educationDao;
	
	public List<Education> getEducationList(int pageNo) {
		pageNo = (pageNo - 1) * 8;
    return educationDao.educationList(pageNo);
	}
	
	public List<Education> getEducationLast() {
		return educationDao.educationLast();
	}
	
	public Education pages() {
		return educationDao.count();
	}
	
	public void insert(Education education) {
		educationDao.insert(education);
	}
	
	public void remove(int eduNo, int mno) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("eduNo", eduNo);
		paramMap.put("mno", mno);
		
		educationDao.delete(paramMap);
	}
	
	public void change(Education education) {
		educationDao.update(education);
	}
	
	public Education getOneEducation(int eduNo) {
		return educationDao.selectOne(eduNo);
	}

	public void addViews(int eduNo) {
		educationDao.addViews(eduNo);
	}
}
