package pms.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.WalkDao;
import pms.domain.Diary;
import pms.domain.Walk;
import pms.service.WalkService;

@Service
public class DefaultWalkService implements WalkService {

  @Autowired WalkDao walkDao;
  
  public int add(Walk walk) {
    return walkDao.add(walk);
  }
  
  public List<Walk> list(int sno) {
    return walkDao.list(sno);
  }
  
  public List<Diary> selectList(Map<String, Object> paramMap) {
    return walkDao.selectList(paramMap);
  }
  
  public Double count() {
    return walkDao.count();
  }
  
}
