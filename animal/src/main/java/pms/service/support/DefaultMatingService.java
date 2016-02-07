package pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.MatingDao;
import pms.domain.Files;
import pms.domain.Mating;
import pms.service.MatingService;

@Service
public class DefaultMatingService implements MatingService {
	
	@Autowired MatingDao matingDao;
	
	public List<Mating> getMatingList(int pageNo) {	
		pageNo = (pageNo - 1) * 12;
		return matingDao.matingList(pageNo);
	}
	
	public List<Mating> getMatingLast() {	
	  return matingDao.matingLast();
	}
	
	public double filterCount(HashMap<String,Object> paramMap) {
	  return matingDao.filterCount(paramMap);
	}
	
  public List<Mating> filter_list(HashMap<String,Object> paramMap) {
    return matingDao.filter_list(paramMap);
  }
  
  public Files getsize(String filename) {
    return matingDao.getsize(filename);
  }
  
	public Mating getMatingOne(int matNo) {
		return matingDao.selectOne(matNo);
	}
	
	public Mating pages() {
		return matingDao.count();
	}
	
	public Mating views(int matNo) {
	  return matingDao.views(matNo);
	}
	
  public void insert(Mating mating) {
  	matingDao.insert(mating);
  }
  
  public int remove(int matNo) {
  	return matingDao.delete(matNo);
  }
  
  public int change(Mating mating) {
  	return matingDao.update(mating);
  }

  public void addviews(int matNo) {
  	matingDao.updateviews(matNo);
  }
}