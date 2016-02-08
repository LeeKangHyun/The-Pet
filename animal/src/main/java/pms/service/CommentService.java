package pms.service;

import java.util.List;
import java.util.Map;

import pms.domain.Comment;

public interface CommentService {
	
  List<Comment> getDiaryComment(int dno);
  List<Comment> getEduComment(Map<String,Object> paramMap);
  List<Comment> getMatComment(int eduNo);
  List<Comment> getSaleComment(Map<String,Object> paramMap);
  List<Comment> getWalkComment(Map<String,Object> paramMap);
  
  Comment pages(int dno);
  Comment edupages(int eduNo);
  Comment salepages(int sno);
  
  int add(Comment comment);
  int walkcom(Comment comment);
  int educom(Comment comment);
  int salecom(Comment comment);

  int removeComment(int comNo);
  int remove(int dno);
  int removeedu(int eduNo);
  int removesale(int sno);
  
  int change(Comment comment);
}







