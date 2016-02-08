package pms.service;

import java.util.HashMap;
import java.util.List;

import pms.domain.Files;
import pms.domain.Sale;

public interface SaleService {
	
	List<Sale> getSaleList(int pageNo);
	List<Sale> getSaleLast();
  
	Sale getSaleOne(int sno);
	
	Sale spages();
	
	Sale sviews(int sno);
	
  void sinsert(Sale sale);
  
  int sremove(int sno);
  
  int schange(Sale sale);
  
  void saddviews(int sno);
  
  double sfilterCount(HashMap<String,Object> paramMap);
  
  List<Sale> sfilter_list(HashMap<String,Object> paramMap);
  
  Files sgetsize(String filename);
  
}







