package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.DiaryDao;
import pms.domain.Diary;
import pms.service.DiaryService;

@Service
public class DefaultDiaryService implements DiaryService {
	
	@Autowired DiaryDao diaryDao;
	
  public List<Diary> getEventList() {
		
		return diaryDao.eventList();
  }
  
  public List<Diary> getPetList(int mno) {
		
		return diaryDao.petList(mno);
  }
  
  public void add(Diary diary) {
  	diaryDao.insert(diary);
  }
  
  public void remove(int dno) {
		
  	diaryDao.delete(dno);
  }
  
  public void change(Diary diary) {
  	diaryDao.update(diary);
  }

}