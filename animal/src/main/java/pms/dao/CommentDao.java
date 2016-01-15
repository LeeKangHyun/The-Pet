package pms.dao;

import java.util.List;

import pms.domain.Comment;

public interface CommentDao {
  List<Comment> DiaryCommentList(int dno);
  List<Comment> EduCommentList(int eduNo);
  List<Comment> MatCommentList(int matNo);
  List<Comment> SaleCommentList(int sno);
  
  void insert(Comment comment);
  
  int deleteComment(int dno);
  
  int update(Comment comment);
}







