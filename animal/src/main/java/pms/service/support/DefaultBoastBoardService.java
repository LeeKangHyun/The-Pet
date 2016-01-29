package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.BoastBoardDao;
import pms.domain.Diary;
import pms.service.BoastBoardService;


@Service
public class DefaultBoastBoardService implements BoastBoardService {
	private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
 
	@Autowired BoastBoardDao boastboardDao;

	
	public List<Diary> selectList(int pageNo, int pageSize) {
	  HashMap<String, Object> paramMap = new HashMap<>();
	  paramMap.put("startIndex", (pageNo - 1) * pageSize);
	  paramMap.put("length", pageSize);
	  
    return boastboardDao.selectList(paramMap);
	}
	
	public double count() {
	  return boastboardDao.count();
	}
	
	public List<Diary> rankList() {
	  return boastboardDao.rankList();
	}
	
  public List<Diary> searchList(int pageNo, int pageSize, Diary diary) {
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("diary", diary);
    
    return boastboardDao.searchList(paramMap);
  }
  
  public double search_title_Count(Diary diary) {
    return boastboardDao.search_title_Count(diary);
  }
  
  
  public double search_member_Count(Diary diary) {
    return boastboardDao.search_member_Count(diary);
  }

  
  public int view(Diary diary) {
    return boastboardDao.view(diary);
  }
  
  public List<Diary> detail_image(Diary diary) {
    return boastboardDao.detail_image(diary);
  }
  
  public List<Diary> detail_content(Diary diary) {
    return boastboardDao.detail_content(diary);
  }

}







