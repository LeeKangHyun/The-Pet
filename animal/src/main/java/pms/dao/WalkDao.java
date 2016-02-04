package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;
import pms.domain.Likes;
import pms.domain.Walk;

public interface WalkDao {
  int add(Walk walk);
  
  List<Walk> list(int dno);
  
  List<Diary> rank();
  List<Diary> ranklist();
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  List<Walk> selectName();
  
  double count();
  
  int view(Diary diary);
  
  int delete(int dno);
  
  
  
  int like_add(Map<String, Object> paramMap);
  
  int like_delete(Map<String, Object> paramMap);
  
  int like_add_update(int like_SCH_NUM);
  
  int like_delete_update(int like_SCH_NUM);
  
  int like_select(int like_SCH_NUM);
  
  Likes detail_like_check(Map<String, Object> paramMap);

}
