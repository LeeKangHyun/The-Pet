package pms.service;

import java.util.List;

import pms.domain.Diary;



public interface DiaryService {
	
  List<Diary> getEventList();
  List<Diary> getPetList(int mno);
  void add(Diary diary);
  void remove(int no);
  void change(Diary diary);
}







