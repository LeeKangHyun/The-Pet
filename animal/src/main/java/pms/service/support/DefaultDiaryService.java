package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.DiaryDao;
import pms.domain.Diary;
import pms.service.DiaryService;

@Service
public class DefaultDiaryService implements DiaryService {
	
	@Autowired DiaryDao diaryDao;
	
	public List<Diary> getEventList(int mno) {
		return diaryDao.eventList(mno);
	}
	
	public List<Diary> getCateList(int pageNo, int pageSize, String keyword, String align) {
  	HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("align", align);
		
		return diaryDao.cateList(paramMap);
  }
	
	public Diary detail(int dno) {
		return diaryDao.selectOne(dno);
	}
  
  public int add(Diary diary) {
  	return diaryDao.insert(diary);
  }
  
  public int remove(int dno) {
		
  	return diaryDao.delete(dno);
  }
  
  public int change(Diary diary) {
  	return diaryDao.update(diary);
  }

}