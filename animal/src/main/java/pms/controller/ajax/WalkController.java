package pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Likes;
import pms.domain.Member;
import pms.domain.Walk;
import pms.service.FilesService;
import pms.service.MemberService;
import pms.service.WalkService;

@Controller("ajax.LotController")
@RequestMapping("walk/ajax/*")
public class WalkController {

  @Autowired WalkService walkService;
  @Autowired FilesService filesService;
  @Autowired MemberService memberService;

  @RequestMapping(value="add", method=RequestMethod.POST)
  public AjaxResult add(Walk walk) throws Exception {

    walkService.add(walk);

    return new AjaxResult("status", null);
  }

  @RequestMapping(value="list", method=RequestMethod.GET)
  public Object list(int dno) throws Exception {
    
    List<Walk> walk = walkService.list(dno);

    return walk;
  }

  @RequestMapping(value="rank", method=RequestMethod.POST)
  public Object rank() throws Exception {
    
    List<Files> files = null;
    Member member = null;    
    
    List<Diary> walks = walkService.top3();
    List<List<Files>> filesMap = new ArrayList<>();
    List<Member> memberMap = new ArrayList<>();
    List<Walk> walkname = walkService.selectName();
    
    for (Diary d : walks) {
    	files = filesService.getDiaryFile(d.getDno());
    	member = memberService.oneMember(d.getMno());
    	filesMap.add(files);
    	memberMap.add(member);
    }
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", walks);
    resultMap.put("filesMap", filesMap);
    resultMap.put("memberMap", memberMap);
    resultMap.put("name", walkname);

    return resultMap;

  }

  @RequestMapping(value="ranklist", method=RequestMethod.POST)
  public Object ranklist() throws Exception {
    
    List<Files> files = null;
    Member member = null;    
    
    List<Diary> walks = walkService.top10();
    List<List<Files>> filesMap = new ArrayList<>();
    List<Member> memberMap = new ArrayList<>();
    List<Walk> walkname = walkService.selectName();
    
    for (Diary d : walks) {
      files = filesService.getDiaryFile(d.getDno());
      member = memberService.oneMember(d.getMno());
      filesMap.add(files);
      memberMap.add(member);
    }
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", walks);
    resultMap.put("filesMap", filesMap);
    resultMap.put("memberMap", memberMap);
    resultMap.put("name", walkname);
    
    return resultMap;
    
  }
  
  @RequestMapping(value="selectList", method=RequestMethod.POST)
  public Object selectList(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="9") int pageSize
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);

    List<Files> files = null;
    Member member = null;
    
    List<Diary> walks = walkService.selectList(paramMap);
    List<List<Files>> filesMap = new ArrayList<>();
    List<Member> memberMap = new ArrayList<>();
    List<Walk> walkname = walkService.selectName();
    
    for (Diary d : walks) {
    	files = filesService.getDiaryFile(d.getDno());
    	member = memberService.oneMember(d.getMno());
    	filesMap.add(files);
    	memberMap.add(member);
    }
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", walks);
    resultMap.put("filesMap", filesMap);
    resultMap.put("memberMap", memberMap);
    resultMap.put("name", walkname);

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
  
  
  @RequestMapping(value="likeAdd", method=RequestMethod.POST)
  public Object like_add(int mno, int dno) throws Exception {

    walkService.like_add(mno, dno);
    walkService.like_add_update(dno);
    int like = walkService.like_select(dno);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }


  @RequestMapping(value="likeDel", method=RequestMethod.POST)
  public Object like_delete(int mno, int dno) throws Exception {

    walkService.like_delete(mno, dno);
    walkService.like_delete_update(dno);
    int like = walkService.like_select(dno);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }


  @RequestMapping(value="detail_like_check", method=RequestMethod.POST)
  public Object detail_like_check(int mno, int dno) throws Exception {
  	
    Likes like = walkService.detail_like_check(mno, dno);
    
    System.out.println("dno : " + dno);
    System.out.println("mno : " + mno);
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("like", like);

    return resultMap;
  }

}
