package pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.FilesDao;
import pms.domain.Files;
import pms.service.FilesService;

@Service
public class DefaultFilesService implements FilesService {
	
	@Autowired FilesDao filesDao;
	
  public List<Files> getDiaryFile(int dno) {
		return filesDao.DiaryFileList(dno);
  }
  public List<Files> getEduFile(int eduNo) {
		return filesDao.EduFileList(eduNo);
  }
  public List<Files> getMatFile(int matNo) {
		return filesDao.MatFileList(matNo);
  }
  public List<Files> getSaleFile(int sno) {
		return filesDao.SaleFileList(sno);
  }
  
  public void add(Files files) {
  	filesDao.insert(files);
  }
  
  /* 대진 작업중 */
  public void eduAdd(Files files) {
  		filesDao.eduInsert(files);
  }
  ///////////////////////////////////////////
  public void fadd(Files files) {
    filesDao.fadd(files);
  }
  ///////////////////////////////////////////
  
  
  public int removeDairyFile(int dno) {
  	return filesDao.deleteDairyFile(dno);
  }
  public int removeEduFile(int eduNo) {
  	return filesDao.deleteEduFile(eduNo);
  }
  public int removeMatFile(int matNo) {
  	return filesDao.deleteMatFile(matNo);
  }
  public int removeSaleFile(int sno) {
  	return filesDao.deleteSaleFile(sno);
  }
  
  public int change(Files files) {
  	return filesDao.update(files);
  }

}