package pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pms.dao.BoastBoardDao;
import pms.domain.AjaxResult;
import pms.domain.Comment;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Likes;
import pms.service.FilesService;
import pms.service.support.DefaultBoastBoardService;

@Controller("ajax.BoastBoardController")
@RequestMapping("/boastboard/ajax/*")
public class BoastBoardController { 

  private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
  //public static final String SAVED_DIR = "/attachfile";

  @Autowired  BoastBoardDao boastBoardDao;
  @Autowired FilesService filesService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="list", method=RequestMethod.POST)
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="12") int pageSize
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);

    log.debug("pageNo = " + pageNo);

    List<Diary> boastboards = boastBoardDao.selectList(paramMap);

    List<Files> fileMap = new ArrayList<Files>();

    for(int i = 0; i < boastboards.size(); i++) {
      fileMap.add(boastBoardDao.getsize(boastboards.get(i).getFilename()));
    }
    

    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("size", fileMap);

    log.debug("Controller/selectList()....호출");

    return resultMap;
  }

  @RequestMapping(value="count", method=RequestMethod.GET)
  public Object count(
      @RequestParam(defaultValue="12") int pageSize
      ) throws Exception {

    double count = boastBoardDao.count();
    count = Math.ceil(count / pageSize);


    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);

    log.debug("Controller/count()....호출");

    return resultMap;
  }

  @RequestMapping(value="rank", method=RequestMethod.GET)
  public Object rank() throws Exception {
    List<Diary> boastboards = boastBoardDao.rankList();

    List<Files> fileMap = new ArrayList<Files>();
    
    for(int i = 0; i < boastboards.size(); i++) {
      fileMap.add(boastBoardDao.getsize(boastboards.get(i).getFilename()));
    }

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("size", fileMap);

    log.debug("Controller/ranktList()....호출");

    return resultMap;
  }

  @RequestMapping(value="search", method=RequestMethod.POST)
  public Object search(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="12") int pageSize,
      Diary diary
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("diary", diary);


    List<Diary> boastboards = boastBoardDao.searchList(paramMap);
    
    List<Files> fileMap = new ArrayList<Files>();
    
    for(int i = 0; i < boastboards.size(); i++) {
      fileMap.add(boastBoardDao.getsize(boastboards.get(i).getFilename()));
    }


    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("size", fileMap);
    
    return resultMap;
  }

  @RequestMapping(value="searchCount", method=RequestMethod.POST)
  public Object searchCount(
      @RequestParam(defaultValue="12") int pageSize,
      Diary diary
      ) throws Exception {

    double count = 0;

    if(diary.getTitle() != null) {
      count = boastBoardDao.search_title_Count(diary);
    } else if(diary.getMember() != null) {
      count = boastBoardDao.search_member_Count(diary);
    }

    log.debug("Count의 갯수는......."+count);

    count = Math.ceil(count / pageSize);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);

    log.debug("Controller/searchCount()....호출");

    return resultMap;
  }
  
  @RequestMapping(value="filter_list", method=RequestMethod.POST)
  public Object filter_list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="12") int pageSize,
      String filter_id
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("filter_id", filter_id);

    List<Diary> boastboards = boastBoardDao.filter_list(paramMap);
    List<Files> fileMap = new ArrayList<Files>();
    for(int i = 0; i < boastboards.size(); i++) {
      fileMap.add(boastBoardDao.getsize(boastboards.get(i).getFilename()));
    }

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("size", fileMap);
    
    return resultMap;
  }
  
  @RequestMapping(value="filterCount", method=RequestMethod.POST)
  public Object filterCount(
      @RequestParam(defaultValue="12") int pageSize,
      String filter_id
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("filter_id", filter_id);
    
    double count = boastBoardDao.filterCount(paramMap);
    log.debug("filterCount의 갯수는......."+count);

    count = Math.ceil(count / pageSize);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);

    log.debug("Controller/searchCount()....호출");

    return resultMap;
  }

  @RequestMapping(value="view", method=RequestMethod.POST)
  public AjaxResult view(Diary diary) throws Exception {
    log.debug("Diary.dno..............?"+diary.getDno());
    boastBoardDao.view(diary);
    return new AjaxResult("success", null);
  }

  @RequestMapping(value="detail_image", method=RequestMethod.POST)
  public Object detail_image(Diary diary) throws Exception {
    log.debug("Diary.dno..............?"+diary.getDno());
    List<Diary> boastboards = boastBoardDao.detail_image(diary);
    int ImageCount = 0;

    log.debug("sql 결과 값 테스트 = " + boastboards.get(0).getFilename());

    ImageCount = boastboards.size();


    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("ImageCount", ImageCount);

    return resultMap;
  }

  @RequestMapping(value="detail_content", method=RequestMethod.POST)
  public Object detail_content(Diary diary, int dno,
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize
      ) throws Exception {

    log.debug("Diary.dno..............?"+diary.getDno());
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("dno", dno);

    List<Diary> boastboards = boastBoardDao.detail_content(diary);
    double count = boastBoardDao.comment_count(dno);
    
    double totalPage = Math.ceil(count / pageSize);
    
    List<Comment> comment = boastBoardDao.comment_list(paramMap);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    resultMap.put("count", count);
    resultMap.put("comment", comment);
    resultMap.put("totalPage", totalPage);

    return resultMap;
  }

  @RequestMapping(value="like_add", method=RequestMethod.POST)
  public Object like_add(String mno, String SCH_NUM) throws Exception {


    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);

    boastBoardDao.like_add(paramMap);
    boastBoardDao.like_add_update(like_SCH_NUM);
    int like = boastBoardDao.like_select(like_SCH_NUM);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }

  @RequestMapping(value="like_delete", method=RequestMethod.POST)
  public Object like_delete(String mno, String SCH_NUM) throws Exception {

    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);

    boastBoardDao.like_delete(paramMap);
    boastBoardDao.like_delete_update(like_SCH_NUM);
    int like = boastBoardDao.like_select(like_SCH_NUM);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }

  @RequestMapping(value="detail_like_check", method=RequestMethod.POST)
  public Object detail_like_check(int mno, String SCH_NUM) throws Exception {

    int like_mno = Integer.valueOf(mno);
    int like_SCH_NUM= Integer.valueOf(SCH_NUM);

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", like_mno);
    paramMap.put("SCH_NUM", like_SCH_NUM);

    List<Likes> like = boastBoardDao.detail_like_check(paramMap);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }

  @RequestMapping(value="delete", method=RequestMethod.POST)
  public AjaxResult like_delete(int dno,
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("dno", dno);
    
    List<Comment> comment = boastBoardDao.comment_list(paramMap);
    
    if (comment.isEmpty()) {
      boastBoardDao.delete_notcmt(dno);
    } else {
      boastBoardDao.delete(dno);
    }

    return new AjaxResult("success", null);
  }

  @RequestMapping(value="comment_add", method=RequestMethod.POST)
  public Object comment_add(int mno, int dno, String content, 
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize) throws Exception {


    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("dno", dno);
    paramMap.put("content", content);
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);

    boastBoardDao.comment_add(paramMap);
    double count = boastBoardDao.comment_count(dno);
    double totalPage = Math.ceil(count / pageSize);
    List<Comment> comment = boastBoardDao.comment_list(paramMap);
    
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", "success");
        resultMap.put("count", count);
        resultMap.put("comment", comment);
        resultMap.put("totalPage", totalPage);

    return resultMap;
  }
  
  @RequestMapping(value="comment_delete", method=RequestMethod.POST)
  public Object comment_delete(int comNo, int dno,
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("dno", dno);

    boastBoardDao.comment_delete(comNo);
    double count = boastBoardDao.comment_count(dno);
    double totalPage = Math.ceil(count / pageSize);
    List<Comment> comment = boastBoardDao.comment_list(paramMap);
    
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", "success");
        resultMap.put("count", count);
        resultMap.put("comment", comment);
        resultMap.put("totalPage", totalPage);

    return resultMap;
  }

}
