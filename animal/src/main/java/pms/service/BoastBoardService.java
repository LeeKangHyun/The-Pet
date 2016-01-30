package pms.service;

import java.util.HashMap;
import java.util.List;

import pms.domain.Diary;
import pms.domain.Likes;



public interface BoastBoardService {
	
  List<Diary> selectList(int pageNo, int pageSize);
  
  double count();
  
  List<Diary> rankList();
  
  List<Diary> searchList(int pageNo, int pageSize, Diary diary);
  
  double search_title_Count(Diary diary);
  
  double search_member_Count(Diary diary);
  
  int view(Diary diary);
  
  List<Diary> detail_image(Diary diary);
  
  List<Diary> detail_content(Diary diary);
  
  int like_add(String mno, String SCH_NUM);

  int like_delete(String mno, String SCH_NUM);
  
  int like_add_update(String SCH_NUM);
  
  int like_delete_update(String SCH_NUM);
  
  int like_select(String SCH_NUM);
  
  public List<Likes> detail_like_check(String mno, String SCH_NUM);

}







