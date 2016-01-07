package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.BoastBoardDao;
import pms.dao.DiaryDao;
import pms.domain.Diary;
import pms.service.BoastBoardService;


@Service
public class DefaultBoastBoardService implements BoastBoardService {
	private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
 
	@Autowired DiaryDao diaryDao;

	
	public List<Diary> selectList(int pageNo, int pageSize, 
      String keyword, String align) {
	  log.debug("selectList() 호출됨");
	  
	  HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    /*diaryDao.selectList(paramMap)*/
    return null;
	}






}







