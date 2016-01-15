package pms.service;

import java.util.List;

import pms.domain.Comment;

public interface CommentService {
	
  List<Comment> getDiaryComment(int dno);
  List<Comment> getEduComment(int eduNo);
  List<Comment> getMatComment(int eduNo);
  List<Comment> getSaleComment(int eduNo);
  
  void add(Comment comment);

  int removeComment(int sno);
  
  int change(Comment comment);
}







