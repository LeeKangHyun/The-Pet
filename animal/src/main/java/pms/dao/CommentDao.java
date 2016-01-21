package pms.dao;

import java.util.List;

import pms.domain.Comment;

public interface CommentDao {
  List<Comment> DiaryCommentList(int dno);
  List<Comment> EduCommentList(int eduNo);
  List<Comment> MatCommentList(int matNo);
  List<Comment> SaleCommentList(int sno);
  
  int insert(Comment comment);
  
  int deleteComment(int comNo);
  
  int update(Comment comment);
}







