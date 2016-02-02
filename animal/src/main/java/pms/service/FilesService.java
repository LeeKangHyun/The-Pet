package pms.service;

import java.util.List;

import pms.domain.Files;



public interface FilesService {
	
  List<Files> getDiaryFile(int dno);
  List<Files> getEduFile(int eduNo);
  List<Files> getMatFile(int matNo);
  List<Files> getSaleFile(int sno);
  
  Files getSize(int dno);
  
  void add(Files files);  
  void eduAdd(Files files);
  void matAdd(Files files);
  ////////////////////////////////////
  void fadd(Files files);
  ////////////////////////////////////
  
  int removeDairyFile(int dno);
  int removeEduFile(int eduNo);
  int removeMatFile(int matNo);
  int removeSaleFile(int sno);
  
  int change(Files files);
}







