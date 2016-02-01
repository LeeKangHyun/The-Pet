package pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pms.domain.AjaxResult;
import pms.domain.Comment;
import pms.domain.Member;
import pms.service.CommentService;
import pms.service.FilesService;
import pms.service.MemberService;

@Controller("ajax.CommentController")
@RequestMapping("/comment/ajax/*")
public class CommentController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired MemberService memberService;
	@Autowired CommentService commentService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;

	@RequestMapping("matcomlist")
	public Object list(int matNo) throws Exception {
		 
		List<Comment> comments = commentService.getMatComment(matNo);
		
		List<Member> memberMap = new ArrayList<>();
		
		for (Comment c : comments) {
			Member member = memberService.oneMember(c.getMno());
			memberMap.add(member);
		}
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("comments", comments);
		resultMap.put("memberMap", memberMap);

		return resultMap;
	}

	@RequestMapping("walkcomlist")
	public Object walkcomlist(int dno) throws Exception {
	  
	  List<Comment> comments = commentService.getDiaryComment(dno);
	  
	  List<Member> memberMap = new ArrayList<>();
	  
	  for (Comment c : comments) {
	    Member member = memberService.oneMember(c.getMno());
	    memberMap.add(member);
	  }
	  
	  HashMap<String,Object> resultMap = new HashMap<>();
	  resultMap.put("status", "success");
	  resultMap.put("comments", comments);
	  resultMap.put("memberMap", memberMap);
	  
	  return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Comment comment) throws Exception {
	
		if (commentService.add(comment) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

	@RequestMapping(value="walkcom", method=RequestMethod.POST)
	public AjaxResult walkcom(
	    Comment comment) throws Exception {
	  
	  if (commentService.walkcom(comment) <= 0) {
	    return new AjaxResult("failure", null);
	  } 
	  
	  return new AjaxResult("success", null);
	}
	
	
	@RequestMapping("delete")
	public AjaxResult delete(
			int comNo) throws Exception {

		if (commentService.removeComment(comNo) <= 0) {
			return new AjaxResult("failure", null);
		} 

		return new AjaxResult("success", null);
	}
}
