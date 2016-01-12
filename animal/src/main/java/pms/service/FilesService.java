package pms.service;

import java.util.List;

import pms.domain.Files;



public interface FilesService {
	
  List<Files> getDiaryFile(int dno);
  List<Files> getEduFile(int eduNo);
  List<Files> getMatFile(int eduNo);
  List<Files> getSaleFile(int eduNo);
  
  void add(Files files);
  //////////////////////////////
  void insert(Files files);
  //////////////////////////////
  
  int removeDairyFile(int dno);
  int removeEduFile(int eduNo);
  int removeMatFile(int matNo);
  int removeSaleFile(int sno);
  
  int change(Files files);
}







