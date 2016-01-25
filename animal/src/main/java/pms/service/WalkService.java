package pms.service;

import java.util.List;

import pms.domain.Lot;

public interface LotService {
  int add(Lot lot);
  
  List<Lot> list(int mno);
}
