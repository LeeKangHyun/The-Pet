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
	
	@Override
	public List<Education> getEducationList(
			int pageNo,
			int pageSize,
			String keyword,
			String align) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    
    return educationDao.selectList(paramMap);
	}
	
	@Override
	public void add(Education education) {
		educationDao.insert(education);
	}
	
	@Override
	public void remove(int eduNo, int mno) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("eduNo", eduNo);
		paramMap.put("mno", mno);
		
		educationDao.delete(paramMap);
	}
	
	@Override
	public void change(Education education) {
		educationDao.update(education);
	}
	
	@Override
	public Education getOneEducation(int eduNo) {
		return educationDao.selectOne(eduNo);
	}
}
