package pms.service.support;

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
	
	public int remove(int eduNo) {
		return educationDao.delete(eduNo);
	}
	
	public int change(Education education) {
		return educationDao.update(education);
	}
	
	public Education getOneEducation(int eduNo) {
		return educationDao.selectOne(eduNo);
	}

	public void addViews(int eduNo) {
		educationDao.addViews(eduNo);
	}
}
