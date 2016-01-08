package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.EducationDao;
import pms.domain.Education;

@Service
public class DefaultEducationService {
	@Autowired EducationDao educationDao;
	
	public List<Education> getEducationList(
			int pageNo,
			int pageSize,
			String keyword,
			String align) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("align", align);
		return educationDao.selectList(paramMap);
	}
	
	public void register(Education education) {
		educationDao.insert(education);
	}
	
	public  void remove(int eduNo, int mno) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("eduNo", eduNo);
		paramMap.put("mno", mno);
		
		educationDao.delete(eduNo, mno);
	}
	
	public void change(Education education) {
		educationDao.update(education);
	}
	
	public Education retrieve(int eduNo) {
		return educationDao.selectOne(eduNo);
	}
}
