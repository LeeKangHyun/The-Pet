package pms.dao;

import java.util.List;

import pms.domain.Files;

public interface FilesDao {
  List<Files> DiaryFileList(int dno);
  List<Files> EduFileList(int eduNo);
  List<Files> MatFileList(int matNo);
  List<Files> SaleFileList(int sno);
  
  void insert(Files files);
  
  ///////////////////////////////////
  void finsert(Files files);
  ///////////////////////////////////
  
  int deleteDairyFile(int dno);
  int deleteEduFile(int eduNo);
  int deleteMatFile(int matNo);
  int deleteSaleFile(int sno);
  
  int update(Files files);
}







