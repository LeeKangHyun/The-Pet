package pms.dao;

import java.util.HashMap;
import java.util.List;

import pms.domain.Files;
import pms.domain.Sale;

public interface SaleDao {
	List<Sale> saleList(int pageNo);
	List<Sale> saleLast();
  
	Sale sselectOne(int sno);
	
	Sale scount();
	
	Sale sviews(int sno);
	
  void sinsert(Sale sale);
  
  void supdateviews(int sno);
  
  int sdelete(int sno);
  
  int supdate(Sale sale);
  
  double sfilterCount(HashMap<String,Object> paramMap);
  
  List<Sale> sfilter_list(HashMap<String,Object> paramMap);
  
  Files sgetsize(String filename);
  
}







