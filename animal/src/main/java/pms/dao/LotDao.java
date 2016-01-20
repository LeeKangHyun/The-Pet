package pms.dao;

import java.util.List;

import pms.domain.Lot;

public interface LotDao {
  int add(Lot lot);
  
  List<Lot> list(int mno);
}
