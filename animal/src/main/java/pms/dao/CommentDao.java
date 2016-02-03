package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Comment;

public interface CommentDao {
  List<Comment> DiaryCommentList(int dno);
  List<Comment> EduCommentList(Map<String,Object> paramMap);
  List<Comment> MatCommentList(int matNo);
  List<Comment> SaleCommentList(int sno);
  List<Comment> WalkCommentList(Map<String,Object> paramMap);
  
  Comment count(int dno);
  
  int insert(Comment comment);
  int walkcom(Comment comment);
  
  int eduinsert(Comment comment);
  
  int deleteComment(int comNo);
  int delete(int dno);
  
  int update(Comment comment);
}







