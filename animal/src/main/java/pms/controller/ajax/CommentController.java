package pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
  public Object list(
      @RequestParam(defaultValue="0") int pageNo, 
      int matNo) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", pageNo);
    paramMap.put("matNo", matNo);

    List<Comment> comments = commentService.getMatComment(paramMap);

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
  public Object walkcomlist(
      @RequestParam(defaultValue="0") int pageNo, 
      int dno
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", pageNo);
    paramMap.put("dno", dno);
    
    List<Comment> comments = commentService.getWalkComment(paramMap);
    
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
  
  @RequestMapping("educomlist")
  public Object educomlist(
      @RequestParam(defaultValue="0") int pageNo, 
      int eduNo
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", pageNo);
    paramMap.put("eduNo", eduNo);
    
    List<Comment> comments = commentService.getEduComment(paramMap);
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
  
  @RequestMapping("salecomlist")
  public Object salecomlist(
      @RequestParam(defaultValue="0") int pageNo, 
      int sno
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", pageNo);
    paramMap.put("sno",sno);
    
  	List<Comment> comments = commentService.getSaleComment(paramMap);

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
  
  @RequestMapping(value="educom", method=RequestMethod.POST)
  public AjaxResult educom(
      Comment comment) throws Exception {

    if (commentService.educom(comment) <= 0) {
      return new AjaxResult("failure", null);
    } 

    return new AjaxResult("success", null);
  }
  
  @RequestMapping(value="salecom", method=RequestMethod.POST)
  public AjaxResult salecom(
      Comment comment) throws Exception {

    if (commentService.salecom(comment) <= 0) {
      return new AjaxResult("failure", null);
    } 

    return new AjaxResult("success", null);
  }
  
  @RequestMapping("pages")
  public Object pages(int dno) throws Exception {

    Comment pages = commentService.pages(dno);

    double page = Math.ceil(pages.getCount()/10);

    return new AjaxResult("success", page);
  }

  @RequestMapping("salepages")
  public Object salepages(int sno) throws Exception {
    
    Comment pages = commentService.salepages(sno);
    
    double page = Math.ceil(pages.getCount()/10);
    
    return new AjaxResult("success", page);
  }

  @RequestMapping("matpages")
  public Object matpages(int matNo) throws Exception {
    
    Comment pages = commentService.matpages(matNo);
    
    double page = Math.ceil(pages.getCount()/10);
    
    return new AjaxResult("success", page);
  }
  
  @RequestMapping("edupages")
  public Object edupages(int eduNo) throws Exception {
  		Comment pages = commentService.edupages(eduNo);

    double page = Math.ceil(pages.getCount()/10);

    return new AjaxResult("success", page);
  }
  
  @RequestMapping("delete")
  public AjaxResult delete(
      int comNo) throws Exception {

    if (commentService.removeComment(comNo) <= 0) {
      return new AjaxResult("failure", null);
    } 

    return new AjaxResult("success", null);
  }

  @RequestMapping("deleteall")
  public AjaxResult deleteall(
      int dno) throws Exception {
    
    if (commentService.remove(dno) <= 0) {
      return new AjaxResult("failure", null);
    } 
    
    return new AjaxResult("success", null);
  }
  
  @RequestMapping("deleteedu")
  public AjaxResult deleteedu(
      int eduNo) throws Exception {
    
    if (commentService.remove(eduNo) <= 0) {
      return new AjaxResult("failure", null);
    } 
    
    return new AjaxResult("success", null);
  }
}
