package pms.service.support;

import java.util.List;

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
  public List<Comment> getEduComment(int eduNo) {
		return commentDao.EduCommentList(eduNo);
  }
  public List<Comment> getMatComment(int matNo) {
		return commentDao.MatCommentList(matNo);
  }
  public List<Comment> getSaleComment(int sno) {
		return commentDao.SaleCommentList(sno);
  }
  
  public void add(Comment comment) {
  	commentDao.insert(comment);
  }

  public int removeComment(int sno) {
  	return commentDao.deleteComment(sno);
  }
  
  public int change(Comment comment) {
  	return commentDao.update(comment);
  }

}