package pms.service.support;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.BoastBoardDao;
import pms.domain.Diary;
import pms.service.BoastBoardService;


@Service
public class DefaultBoastBoardService implements BoastBoardService {
	private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
 
	@Autowired BoastBoardDao boastboardDao;

	
	public List<Diary> selectList() {
    return boastboardDao.selectList();
	}
	
	public List<Diary> rankList() {
	  return boastboardDao.rankList();
	}
	
	public Diary selectOne(int dno) {
	  return boastboardDao.selectOne(dno);
	}






}







