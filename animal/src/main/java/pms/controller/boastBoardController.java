package pms.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pms.dao.boastBoardDao;
import pms.domain.boastBoard;

@Controller("ajax.boastBoardController")
@RequestMapping("/boastBoard/ajax/*")
public class boastBoardController { 

  @Autowired boastBoardService boastboardService;
  @Autowired ServletContext servletContext;

  @RequestMapping("list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="no") String keyword,
      @RequestParam(defaultValue="desc") String align) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);

    List<boastBoard> boastBoards = boastBoardDao.selectList(paramMap);

    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", boastBoards);

    return resultMap;
  }
}
