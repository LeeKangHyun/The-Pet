package pms.service;

import java.util.List;

import pms.domain.Comment;

public interface CommentService {
	
  List<Comment> getDiaryComment(int dno);
  List<Comment> getEduComment(int eduNo);
  List<Comment> getMatComment(int eduNo);
  List<Comment> getSaleComment(int eduNo);
  
  int add(Comment comment);
  int walkcom(Comment comment);

  int removeComment(int comNo);
  
  int change(Comment comment);
}







