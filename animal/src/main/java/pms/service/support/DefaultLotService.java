package pms.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.LotDao;
import pms.domain.Lot;
import pms.service.LotService;

@Service
public class DefaultLotService implements LotService {

  @Autowired LotDao lotDao;
  
  public void add(Lot lot) {
    lotDao.add(lot);
  }
}
