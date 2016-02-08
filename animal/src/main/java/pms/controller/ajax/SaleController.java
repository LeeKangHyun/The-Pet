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
import pms.domain.Member;
import pms.domain.Sale;
import pms.service.CommentService;
import pms.service.DiaryService;
import pms.service.FilesService;
import pms.service.MemberService;
import pms.service.SaleService;

@Controller("ajax.SaleController")
@RequestMapping("/sale/ajax/*")
public class SaleController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired SaleService saleService;
	@Autowired FilesService filesService;
	@Autowired MemberService memberService;
	@Autowired CommentService commentService;
	@Autowired ServletContext servletContext;
	
	
	
	@RequestMapping(value="filterCount", method=RequestMethod.POST)
  public Object filterCount(
      @RequestParam(defaultValue="12") int pageSize,
      String sfilter_id
      ) throws Exception {
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("sfilter_id", sfilter_id);
    
    double count = saleService.sfilterCount(paramMap);

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
      String sfilter_id
      ) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("sfilter_id", sfilter_id);

    List<Sale> sales = saleService.sfilter_list(paramMap);
    List<Files> fileMap = new ArrayList<Files>();
    for(int i = 0; i < sales.size(); i++) {
      fileMap.add(saleService.sgetsize(sales.get(i).getFilename()));
    }

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("data", sales);
    resultMap.put("size", fileMap);
    
    return resultMap;
  }
	
	
	
	@RequestMapping("pages")
	public Object pages() throws Exception {

		Sale pages = saleService.spages();
		
		double page = Math.ceil(pages.getCount()/4);
		
		return new AjaxResult("success", page);
	}
	
	@RequestMapping("views")
	public Object views(int sno) throws Exception {

	  Sale sale = saleService.sviews(sno);
	  
	  return new AjaxResult("success", sale);
	}
	
	
	
	@RequestMapping("list")
	public Object list(@RequestParam(defaultValue="1") int pageNo) throws Exception {
		 
		List<Sale> sale = saleService.getSaleList(pageNo);
		List<Files> files = null;
		Member member = null;

		List<List<Files>> filesMap = new ArrayList<>();
		List<Member> memberMap = new ArrayList<>();

		for (Sale s : sale) {
			files = filesService.getSaleFile(s.getSno());
			member = memberService.oneMember(s.getSno());
			filesMap.add(files);
			memberMap.add(member);
		}
			
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("sale", sale);
		resultMap.put("filesMap", filesMap);
		resultMap.put("memberMap", memberMap);

		return resultMap;
	}

	@RequestMapping("detail")
	public Object detail(int sno) throws Exception {

		Sale sale = saleService.getSaleOne(sno);
		saleService.saddviews(sno);
		Member member = memberService.oneMember(sale.getMno());
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("sale", sale);
		resultMap.put("member", member);
		
		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public Object add(Sale sale) throws Exception {
	  
	  saleService.sinsert(sale);
	  
	   List<Sale> sal = saleService.getSaleLast();
	    int lastDno = 0;
	    for (Sale s : sal) {
	      lastDno = s.getSno();
	    }
	 
	  return new AjaxResult("success", lastDno);
	}
	

	@RequestMapping(value="delete", method=RequestMethod.GET)
	public AjaxResult delete(
			int sno) throws Exception {
	  
	  commentService.removeComment(sno);
	  filesService.removeMatFile(sno);
	  saleService.sremove(sno);
		 
		return new AjaxResult("success", null);
	}
	
	/////////// 위까진 성공
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(Sale sale) throws Exception {
		
		System.out.println(sale.getsContent());
		System.out.println(sale.getSno());		
		
		if (saleService.schange(sale) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

}
