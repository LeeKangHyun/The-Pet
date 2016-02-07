package pms.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.EducationDao;
import pms.domain.Education;
import pms.domain.Likes;
import pms.service.EducationService;

@Service
public class DefaultEducationService implements EducationService {

	@Autowired EducationDao educationDao;
	
	public List<Education> getEducationList(int pageNo) {
		pageNo = (pageNo - 1) * 6;
    return educationDao.educationList(pageNo);
	}
	
	public List<Education> getEducationSList(HashMap<String,Object> educationMap) {
		return educationDao.educationSList(educationMap);
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
	
	public int like_add(Map<String, Object> paramMap) {
	  return educationDao.like_add(paramMap);
	}
	
	public int like_delete(Map<String, Object> paramMap) {
	    return educationDao.like_delete(paramMap);
	  }
	
	public int like_select(int like_eno) {
	  return educationDao.like_select(like_eno);
	}
	
	 public Likes like_check(Map<String, Object> paramMap) {
	    return educationDao.like_check(paramMap);
	  }
	 
	 public void addLikes(int eduNo) {
		 educationDao.addLikes(eduNo);
	 }
	 
	 public void deleteLikes(int eduNo) {
		 educationDao.deleteLikes(eduNo);
	 }
	 
	  public double filterCount(Map<String, Object> paramMap) {
	    return educationDao.filterCount(paramMap);
	  }
	  
	  public List<Education> filter_list(Map<String, Object> paramMap) {
      return educationDao.filter_list(paramMap);
    }
}
