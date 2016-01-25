package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.WalkDao;
import pms.domain.Walk;
import pms.service.WalkService;

@Service
public class DefaultWalkService implements WalkService {

  @Autowired WalkDao lotDao;
  
  public int add(Walk lot) {
    return lotDao.add(lot);
  }
  
  public List<Walk> list(int mno) {
    return lotDao.list(mno);
  }
}
