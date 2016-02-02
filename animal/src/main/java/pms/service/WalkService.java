package pms.service;

import java.util.List;
import java.util.Map;

import pms.domain.Diary;
import pms.domain.Likes;
import pms.domain.Walk;

public interface WalkService {
  int add(Walk walk);
  
  List<Walk> list(int dno);
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  List<Walk> selectName();
  
  public Double count();

  int view(Diary diary);
  
  int remove(int dno);
  
  int like_add(int mno, int dno);

  int like_delete(int mno, int dno);
  
  int like_add_update(int dno);
  
  int like_delete_update(int dno);
  
  int like_select(int dno);
  
  public Likes detail_like_check(int mno, int dno);
}
