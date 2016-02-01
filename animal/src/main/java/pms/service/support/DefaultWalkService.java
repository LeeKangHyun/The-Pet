package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.WalkDao;
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
}
