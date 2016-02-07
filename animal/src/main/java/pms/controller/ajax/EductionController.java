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
import pms.domain.Education;
import pms.domain.Files;
import pms.domain.Likes;
import pms.service.CommentService;
import pms.service.EducationService;
import pms.service.FilesService;

@Controller("ajax.EducationController")
@RequestMapping("/Education/education/ajax/*")
public class EductionController {
	public static final String SAVED_DIR = "/files";
	
	@Autowired EducationService educationService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;
	@Autowired CommentService commentService;
	
	
	@RequestMapping("pages")
	public Object pages() throws Exception {
		Education pages = educationService.pages();
		
		double page = Math.ceil(pages.getCount()/6);
		
		return new AjaxResult("success", page);
	}
	
	@RequestMapping("list")
	public Object list(@RequestParam(defaultValue="1") int pageNo) throws Exception {
    
		List<Education> educations = educationService.getEducationList(pageNo);
		List<Files> files = null;
		List<List<Files>> filesMap = new ArrayList<>();
		
		for (Education e : educations) {
			files = filesService.getEduFile(e.getEduNo());
			filesMap.add(files);
		}
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("educations", educations);
		resultMap.put("filesMap", filesMap);
		
		return resultMap;
	}
	
	@RequestMapping("slist")
	public Object slist(@RequestParam String eduSpec,
			@RequestParam int eduNo) throws Exception {
		HashMap<String,Object> educationMap = new HashMap<>();
		educationMap.put("eduSpec", eduSpec);
		educationMap.put("eduNo", eduNo);
		List<Education> educations = educationService.getEducationSList(educationMap);
		System.out.println(eduSpec);
		List<Files> files = null;
		List<List<Files>> filesMap = new ArrayList<>();
		
		for (Education e : educations) {
			files = filesService.getEduFile(e.getEduNo());
			filesMap.add(files);
		}
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("educations", educations);
		resultMap.put("filesMap", filesMap);
		
		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Education education) throws Exception {
		
		educationService.insert(education);
		
		List<Education> educations = educationService.getEducationLast();
		int eduNo = 0;
		for (Education e : educations) {
			eduNo = e.getEduNo();
		}
		return new AjaxResult("success", eduNo);
	}
		
	
	@RequestMapping("detail")
	public Object detail(int eduNo) throws Exception {
    educationService.addViews(eduNo);
    
    HashMap<String,Object> resultMap = new HashMap<>();
		Education education = educationService.getOneEducation(eduNo);
		List<Files> files = filesService.getEduFile(education.getEduNo());
		
		resultMap.put("status", "success");
		resultMap.put("education", education);
		resultMap.put("files", files);
		
		return resultMap;
	}
	
//	@RequestMapping(value="update", method=RequestMethod.POST)
//	public AjaxResult update(
//			Education education,
//			Files files,
//			Member member,
//			MultipartFile file) throws Exception {
//		
//		if (file.getSize() > 0) {
//			String newFileName  = MultipartHelper.generateFilename(file.getOriginalFilename());
//			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
//																+ "/" + newFileName);
//			file.transferTo(attachfile);
//			
//			files.setFileName(newFileName);
//		} else if (files.getFileName().length() == 0) {
//			files.setFileName(null);
//		}
//		
//		return new AjaxResult("success", files);
//	}
//	
	@RequestMapping("delete")
	public AjaxResult delete(int eduNo) throws Exception {
		filesService.removeEduFile(eduNo);
		commentService.removeedu(eduNo);
		
		if (educationService.remove(eduNo) <= 0) {
			return new AjaxResult("failure", null);
		}
		return new AjaxResult("success", null);
	}
	
	
	 @RequestMapping("like_add")
	  public Object like_add(String mno, String eno) throws Exception {
	   
	    int like_mno = Integer.valueOf(mno);
	    int like_eno= Integer.valueOf(eno);

	    HashMap<String, Object> paramMap = new HashMap<>();
	    paramMap.put("mno", like_mno);
	    paramMap.put("eno", like_eno);

	    educationService.like_add(paramMap);
	    int like = educationService.like_select(like_eno);
	    
	    HashMap<String, Object> resultMap = new HashMap<>();
	    resultMap.put("status", "success");
	    resultMap.put("like", like);
	    
	    educationService.addLikes(like_eno);
	    return resultMap;
	  }
	 
   @RequestMapping("like_delete")
   public Object like_delete(String mno, String eno) throws Exception {
    
     int like_mno = Integer.valueOf(mno);
     int like_eno= Integer.valueOf(eno);

     HashMap<String, Object> paramMap = new HashMap<>();
     paramMap.put("mno", like_mno);
     paramMap.put("eno", like_eno);

     educationService.like_delete(paramMap);
     int like = educationService.like_select(like_eno);
     
     HashMap<String, Object> resultMap = new HashMap<>();
     resultMap.put("status", "success");
     resultMap.put("like", like);

     educationService.deleteLikes(like_eno);
     return resultMap;
   }
   
   @RequestMapping(value="like_check", method=RequestMethod.POST)
   public Object detail_like_check(String mno, String eno) throws Exception {

     int like_mno = Integer.valueOf(mno);
     int like_eno= Integer.valueOf(eno);

     HashMap<String, Object> paramMap = new HashMap<>();
     paramMap.put("mno", like_mno);
     paramMap.put("eno", like_eno);

     Likes like = educationService.like_check(paramMap);
     int like_count = educationService.like_select(like_eno);

     HashMap<String, Object> resultMap = new HashMap<>();
     resultMap.put("status", "success");
     resultMap.put("like", like);
     resultMap.put("like_count", like_count);

     return resultMap;
   }
	
}
