package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.SaleDao;
import pms.domain.Files;
import pms.domain.Sale;
import pms.service.SaleService;

@Service
public class DefaultSaleService implements SaleService {
	
	@Autowired SaleDao saleDao;
	
	public List<Sale> getSaleList(int pageNo) {	
		pageNo = (pageNo - 1) * 4;
		return saleDao.saleList(pageNo);
	}
	
	public List<Sale> getSaleLast() {	
	  return saleDao.saleLast();
	}
	
	public double sfilterCount(HashMap<String,Object> paramMap) {
	  return saleDao.sfilterCount(paramMap);
	}
	
  public List<Sale> sfilter_list(HashMap<String,Object> paramMap) {
    return saleDao.sfilter_list(paramMap);
  }
  
  public Files sgetsize(String filename) {
    return saleDao.sgetsize(filename);
  }
  
	public Sale getSaleOne(int sno) {
		return saleDao.sselectOne(sno);
	}
	
	public Sale spages() {
		return saleDao.scount();
	}
	
	public Sale sviews(int sno) {
	  return saleDao.sviews(sno);
	}
	
  public void sinsert(Sale sale) {
  		saleDao.sinsert(sale);
  }
  
  public int sremove(int sno) {
  		return saleDao.sdelete(sno);
  }
  
  public int schange(Sale sale) {
  		return saleDao.supdate(sale);
  }

  public void saddviews(int sno) {
  		saleDao.supdateviews(sno);
  }
}