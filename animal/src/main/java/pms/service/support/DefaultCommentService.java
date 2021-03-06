package pms.service.support;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.CommentDao;
import pms.domain.Comment;
import pms.service.CommentService;

@Service
public class DefaultCommentService implements CommentService {
	
	@Autowired CommentDao commentDao;
	
  public List<Comment> getDiaryComment(int dno) {
		return commentDao.DiaryCommentList(dno);
  }
  public List<Comment> getEduComment(Map<String,Object> paramMap) {
		return commentDao.EduCommentList(paramMap);
  }
  public List<Comment> getMatComment(Map<String,Object> paramMap) {
		return commentDao.MatCommentList(paramMap);
  }
  public List<Comment> getSaleComment(Map<String,Object> paramMap) {
		return commentDao.SaleCommentList(paramMap);
  }
  
  public List<Comment> getWalkComment(Map<String,Object> paramMap) {
    return commentDao.WalkCommentList(paramMap);
  }
  
  public Comment pages(int dno) {
    return commentDao.count(dno);
  }
  
  public Comment edupages(int eduNo) {
    return commentDao.educount(eduNo);
  }
  
  public Comment salepages(int sno) {
  		return commentDao.salecount(sno);
  }
  public Comment matpages(int matNo) {
    return commentDao.matcount(matNo);
  }
  
  public int add(Comment comment) {
  	return commentDao.insert(comment);
  }
  public int walkcom(Comment comment) {
    return commentDao.walkcom(comment);
  }
  public int educom(Comment comment) {
  		return commentDao.eduinsert(comment);
  }
  public int salecom(Comment comment) {
  		return commentDao.salecom(comment);
  }

  public int removeComment(int comNo) {
  	return commentDao.deleteComment(comNo);
  }
  
  public int remove(int dno) {
    return commentDao.delete(dno);
  }
  
  public int removeedu(int eduNo) {
  		return commentDao.deleteedu(eduNo);
  }
  
  public int removesale(int sno) {
  		return commentDao.deletesale(sno);
  }
  
  public int change(Comment comment) {
  	return commentDao.update(comment);
  }

}