package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.LotDao;
import pms.domain.Lot;
import pms.service.LotService;

@Service
public class DefaultLotService implements LotService {

  @Autowired LotDao lotDao;
  
  public int add(Lot lot) {
    return lotDao.add(lot);
  }
  
  public List<Lot> list(int mno) {
    return lotDao.list(mno);
  }
}
