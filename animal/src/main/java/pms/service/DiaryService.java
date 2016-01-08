package pms.service;

import java.util.List;

import pms.domain.Diary;



public interface DiaryService {
	
  List<Diary> getEventList();
  List<Diary> getBoardList(
  		int pageNo, int pageSize, String keyword, String align);
  void add(Diary diary);
  int remove(int no);
  int change(Diary diary);
}







