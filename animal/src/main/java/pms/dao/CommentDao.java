package pms.dao;

import java.util.List;
import java.util.Map;

import pms.domain.Comment;

public interface CommentDao {
  List<Comment> DiaryCommentList(int dno);
  List<Comment> EduCommentList(Map<String,Object> paramMap);
  List<Comment> MatCommentList(Map<String,Object> paramMap);
  List<Comment> SaleCommentList(Map<String,Object> paramMap);
  List<Comment> WalkCommentList(Map<String,Object> paramMap);
  
  Comment count(int dno);
  Comment educount(int eduNo);
  Comment salecount(int sno);
  Comment matcount(int matNo);
  
  int insert(Comment comment);
  int walkcom(Comment comment);
  int eduinsert(Comment comment);
  int salecom(Comment comment);
  
  int deleteComment(int comNo);
  int delete(int dno);
  int deleteedu(int eduNo);
  int deletesale(int sno);
  
  int update(Comment comment);
}







