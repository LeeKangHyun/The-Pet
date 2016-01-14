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

  @RequestMapping(value="list", method=RequestMethod.GET)
  public Object list() throws Exception {
    List<Diary> boastboards = boastBoardDao.selectList();
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastboards);
    
    log.debug("Controller/selectList()....호출");

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
  

}
