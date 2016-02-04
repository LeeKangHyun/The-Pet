package pms.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.WalkDao;
import pms.domain.Diary;
import pms.domain.Likes;
import pms.domain.Walk;
import pms.service.WalkService;

@Service
public class DefaultWalkService implements WalkService {

  @Autowired WalkDao walkDao;
  
  public int add(Walk walk) {
    return walkDao.add(walk);
  }
  
  public List<Diary> top3() {
  	return walkDao.rank();
  }
  
  public List<Diary> top10() {
    return walkDao.ranklist();
  }
  
  public List<Walk> list(int dno) {
    return walkDao.list(dno);
  }
  
  public List<Diary> selectList(Map<String, Object> paramMap) {
    return walkDao.selectList(paramMap);
  }
  
  public List<Walk> selectName() {
    return walkDao.selectName();
  }
  
  public Double count() {
    return walkDao.count();
  }
  
  public int view(Diary diary) {
    return walkDao.view(diary);
  }
  
  public int remove(int dno) {
  	return walkDao.delete(dno);
  }
  
  
  
public int like_add(int mno, int dno){
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("dno", dno);
    
    return walkDao.like_add(paramMap);
  };
  
  public int like_delete(int mno, int dno){
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("dno", dno);
    
    return walkDao.like_delete(paramMap);
  };
  
  public int like_add_update(int dno){
    
    return walkDao.like_add_update(dno);
  };
  
  public int like_delete_update(int dno){
    
    return walkDao.like_delete_update(dno);
  };
  
  public int like_select(int dno){
    
    return walkDao.like_select(dno);
  };
  
  
  public Likes detail_like_check(int mno, int dno) {

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("dno", dno);
    
    return walkDao.detail_like_check(paramMap);
  }
}
