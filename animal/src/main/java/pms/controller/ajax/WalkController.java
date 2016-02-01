package pms.controller.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pms.domain.AjaxResult;
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
  public Object list(int mno) throws Exception {
    System.out.println(mno);
    List<Walk> walk = walkService.list(mno);
    
    return walk;
  }
}
