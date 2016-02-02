package pms.service;

import java.util.List;

import pms.domain.Diary;



public interface DiaryService {
	
  List<Diary> getEventList(int mno);
  List<Diary> getCateList(
  		int pageNo, int pageSize, String keyword, String align);
  Diary detail(int dno);
  int add(Diary diary);
  int remove(int dno);
  int change(Diary diary);
  int changeColor(Diary diary);
}







