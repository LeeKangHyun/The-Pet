package pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.domain.Walk;
import pms.service.WalkService;

@Controller("ajax.LotController")
@RequestMapping("walk/ajax/*")
public class WalkController {

  @Autowired WalkService walkService;

  @RequestMapping(value="add", method=RequestMethod.POST)
  public AjaxResult add(Walk walk) throws Exception {

    walkService.add(walk);

    return new AjaxResult("status", null);
  }

  @RequestMapping(value="list", method=RequestMethod.GET)
  public Object list(int dno) throws Exception {
    System.out.println(dno);
    List<Walk> walk = walkService.list(dno);

    return walk;
  }

  @RequestMapping(value="selectList", method=RequestMethod.POST)
  public Object selectList(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="9") int pageSize
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);

    List<Diary> walks = walkService.selectList(paramMap);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", walks);

    return resultMap;
  }

  @RequestMapping(value="count", method=RequestMethod.GET)
  public Object count(
      @RequestParam(defaultValue="9") int pageSize
      ) throws Exception {

    double count = walkService.count();
    count = Math.ceil(count / pageSize);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);

    return resultMap;
  }
  
  @RequestMapping(value="view", method=RequestMethod.POST)
  public AjaxResult view(Diary diary) throws Exception {
    walkService.view(diary);
    return new AjaxResult("success", null);
  }

}
