package pms.service.support;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pms.dao.BoastBoardDao;
import pms.domain.AjaxResult;
import pms.domain.Comment;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Likes;
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
  
  public List<Diary> filter_list(int pageNo, int pageSize, String filter_id) {
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("filter_id", filter_id);
    
    return boastboardDao.searchList(paramMap);
  }
  
  public double filterCount(String filter_id) {
    return boastboardDao.filterCount(filter_id);
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
  
  public int like_add(String mno, String SCH_NUM){
    
    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);
    
    return boastboardDao.like_add(paramMap);
  };
  
  public int like_delete(String mno, String SCH_NUM){
    
    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);
    
    return boastboardDao.like_delete(paramMap);
  };
  
  public int like_add_update(String SCH_NUM){
    
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);
    
    return boastboardDao.like_add_update(like_SCH_NUM);
  };
  
  public int like_delete_update(String SCH_NUM){
    
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);
    
    return boastboardDao.like_delete_update(like_SCH_NUM);
  };
  
  public int like_select(String SCH_NUM){
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);
    return boastboardDao.like_select(like_SCH_NUM);
  };
  
  
  public List<Likes> detail_like_check(String mno, String SCH_NUM) {

    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);
    
    return boastboardDao.detail_like_check(paramMap);
  }
  
  
  public int delete(int dno) {
    return boastboardDao.delete(dno);
  }
  
  public int delete_notcmt(int dno) {
    return boastboardDao.delete_notcmt(dno);
  }
  
  public int comment_add(int mno, int dno, String content){
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("dno", dno);
    paramMap.put("content", content);
    
    return boastboardDao.comment_add(paramMap);
  };
  
  public int comment_delete(int comNo){
    return boastboardDao.comment_delete(comNo);
  };
  
  public double comment_count(int dno){
    return boastboardDao.comment_count(dno);
  };
  
  
  public List<Comment> comment_list(int dno){
    return boastboardDao.comment_list(dno);
  };
  
  
  public Files getsize(String filename) {
    return boastboardDao.getsize(filename);
  }

}







