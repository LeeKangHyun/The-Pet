package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Comment;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Likes;

public interface BoastBoardDao {
  
  List<Diary> selectList(Map<String, Object> paramMap);
  
  double count();
  
  List<Diary> rankList();
  
  List<Diary> searchList(Map<String, Object> paramMap);
  
  List<Diary> filter_list(Map<String, Object> paramMap);
  
  double filterCount(Map<String, Object> paramMap);
  
  double search_title_Count(Diary diary);
  
  double search_member_Count(Diary diary);
  
  int view(Diary diary); 
  
  List<Diary> detail_image(Diary diary);
  
  List<Diary> detail_content(Diary diary);
  
  int like_add(Map<String, Object> paramMap);
  
  int like_delete(Map<String, Object> paramMap);
  
  int like_add_update(int like_SCH_NUM);
  
  int like_delete_update(int like_SCH_NUM);
  
  int like_select(int like_SCH_NUM);
  
  List<Likes> detail_like_check(Map<String, Object> paramMap);
  
  int delete(int dno);
  
  int comment_add(Map<String, Object> paramMap);
  
  int comment_delete(int comNo);
  
  double comment_count(int dno);
  
  List<Comment> comment_list(int dno);
  
  Files getsize(String filename);
  
  int delete_notcmt(int dno);
}







