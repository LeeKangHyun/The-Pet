package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;

public interface BoastBoardDao {
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  double count();
  
  List<Diary> rankList();
  
  List<Diary> searchList(Map<String, Object> paramMap);
  
  double search_title_Count(Diary diary);
  
  double search_member_Count(Diary diary);
  
  int view(Diary diary); 
  
  List<Diary> detail_image(Diary diary);
  
  List<Diary> detail_content(Diary diary);
  
  
  
}







