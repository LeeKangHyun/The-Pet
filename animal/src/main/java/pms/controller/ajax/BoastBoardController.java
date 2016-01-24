package pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pms.dao.BoastBoardDao;
import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.service.support.DefaultBoastBoardService;

@Controller("ajax.BoastBoardController")
@RequestMapping("/boastboard/ajax/*")
public class BoastBoardController { 
  
  private static Logger log = Logger.getLogger(DefaultBoastBoardService.class);
  //public static final String SAVED_DIR = "/attachfile";

  @Autowired  BoastBoardDao boastBoardDao;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="list", method=RequestMethod.POST)
  public Object list(
  @RequestParam(defaultValue="1") int pageNo,
  @RequestParam(defaultValue="16") int pageSize
  ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    
    log.debug("pageNo = " + pageNo);
    
    List<Diary> boastboards = boastBoardDao.selectList(paramMap);
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    
    log.debug("Controller/selectList()....호출");

    return resultMap;
  }
  
  
  
  
  
  @RequestMapping(value="count", method=RequestMethod.GET)
  public Object count(
  @RequestParam(defaultValue="16") int pageSize
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
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    
    log.debug("Controller/ranktList()....호출");

    return resultMap;
  }
  
  
  @RequestMapping(value="detail", method=RequestMethod.GET)
  public Object detail(int dno) throws Exception {
    Diary diary = boastBoardDao.selectOne(dno);
    return new AjaxResult("success", diary);
  }
  
  
  
  @RequestMapping(value="search", method=RequestMethod.POST)
  public Object search(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="16") int pageSize,
      Diary diary
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("diary", diary);
    
    
    List<Diary> boastboards = boastBoardDao.searchList(paramMap);
    

    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    
    return resultMap;
  }
  
  @RequestMapping(value="searchCount", method=RequestMethod.GET)
  public Object searchCount(
  @RequestParam(defaultValue="16") int pageSize,
  Diary diary
  ) throws Exception {
   
    double count = boastBoardDao.searchCount(diary);
    count = Math.ceil(count / pageSize);
    
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);
    
    log.debug("Controller/searchCount()....호출");

    return resultMap;
  }
  

}
