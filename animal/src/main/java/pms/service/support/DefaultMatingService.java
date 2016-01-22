package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.MatingDao;
import pms.domain.Mating;
import pms.service.MatingService;

@Service
public class DefaultMatingService implements MatingService {
	
	@Autowired MatingDao matingDao;
	
	public List<Mating> getMatingList(int pageNo) {	
		pageNo = (pageNo - 1) * 4;
		return matingDao.matingList(pageNo);
	}
  
	public Mating getMatingOne(int matNo) {
		return matingDao.selectOne(matNo);
	}
	
	public Mating pages() {
		return matingDao.count();
	}
	
  public void addPet(Mating mating) {
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