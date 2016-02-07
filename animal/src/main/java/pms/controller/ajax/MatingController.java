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
import pms.domain.Files;
import pms.domain.Mating;
import pms.domain.Member;
import pms.service.CommentService;
import pms.service.DiaryService;
import pms.service.FilesService;
import pms.service.MatingService;
import pms.service.MemberService;

@Controller("ajax.MatingController")
@RequestMapping("/mating/ajax/*")
public class MatingController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired MatingService matingService;
	@Autowired FilesService filesService;
	@Autowired MemberService memberService;
	@Autowired CommentService commentService;
	@Autowired ServletContext servletContext;
	
	
	
	@RequestMapping(value="filterCount", method=RequestMethod.POST)
  public Object filterCount(
      @RequestParam(defaultValue="12") int pageSize,
      String filter_id
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("filter_id", filter_id);
    
    double count = matingService.filterCount(paramMap);

    count = Math.ceil(count / pageSize);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("count", count);

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

    List<Mating> matings = matingService.filter_list(paramMap);
    List<Files> fileMap = new ArrayList<Files>();
    for(int i = 0; i < matings.size(); i++) {
      fileMap.add(matingService.getsize(matings.get(i).getFilename()));
    }

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", matings);
    resultMap.put("size", fileMap);
    
    return resultMap;
  }
	
	
	
	@RequestMapping("pages")
	public Object pages() throws Exception {

		Mating pages = matingService.pages();
		
		double page = Math.ceil(pages.getCount()/12);
		
		return new AjaxResult("success", page);
	}
	
	@RequestMapping("views")
	public Object views(int matNo) throws Exception {

	  Mating mating = matingService.views(matNo);
	  
	  return new AjaxResult("success", mating);
	}
	
	
	
	@RequestMapping("list")
	public Object list(@RequestParam(defaultValue="1") int pageNo) throws Exception {
		 
		List<Mating> mating = matingService.getMatingList(pageNo);
		List<Files> files = null;
		Member member = null;

		List<List<Files>> filesMap = new ArrayList<>();
		List<Member> memberMap = new ArrayList<>();

		for (Mating m : mating) {
			files = filesService.getMatFile(m.getMatNo());
			member = memberService.oneMember(m.getMno());
			filesMap.add(files);
			memberMap.add(member);
		}
			
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("mating", mating);
		resultMap.put("filesMap", filesMap);
		resultMap.put("memberMap", memberMap);

		return resultMap;
	}

	@RequestMapping("detail")
	public Object detail(int matNo) throws Exception {

		Mating mating = matingService.getMatingOne(matNo);
		matingService.addviews(matNo);
		Member member = memberService.oneMember(mating.getMno());
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("mating", mating);
		resultMap.put("member", member);
		

		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public Object add(
			Mating mating
			) throws Exception {
	  
	  matingService.insert(mating);
	  
	   List<Mating> mat = matingService.getMatingLast();
	    int lastDno = 0;
	    for (Mating d : mat) {
	      lastDno = d.getMatNo();
	    }
	 
	  return new AjaxResult("success", lastDno);
	}
	

	@RequestMapping(value="delete", method=RequestMethod.GET)
	public AjaxResult delete(
			int matNo) throws Exception {
	  
	  commentService.removeComment(matNo);
	  filesService.removeMatFile(matNo);
	  matingService.remove(matNo);
		 
		return new AjaxResult("success", null);
	}
	
	/////////// 위까진 성공
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(Mating mating) throws Exception {
		
		System.out.println(mating.getMatContent());
		System.out.println(mating.getMatNo());		
		
		if (matingService.change(mating) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

}
