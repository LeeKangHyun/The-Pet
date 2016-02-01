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

import pms.dao.FilesDao;
import pms.domain.AjaxResult;
import pms.domain.Education;
import pms.domain.Files;
import pms.service.EducationService;

@Controller("ajax.EducationController")
@RequestMapping("/Education/education/ajax/*")
public class EductionController {
	public static final String SAVED_DIR = "/files";
	
	@Autowired EducationService educationService;
	@Autowired FilesDao filesDao;
	@Autowired ServletContext servletContext;
	
	
	@RequestMapping("pages")
	public Object pages() throws Exception {
		Education pages = educationService.pages();
		
		double page = Math.ceil(pages.getCount()/8);
		
		return new AjaxResult("success", page);
	}
	
	@RequestMapping("list")
	public Object list(@RequestParam(defaultValue="1") int pageNo) throws Exception {
    
		List<Education> educations = educationService.getEducationList(pageNo);
		List<Files> files = null;
		List<List<Files>> filesMap = new ArrayList<>();
		
		for (Education e : educations) {
			files = filesDao.EduFileList(e.getEduNo());
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
		List<Files> files = filesDao.EduFileList(education.getEduNo());
		
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
//	@RequestMapping("delete")
//	public AjaxResult delete(
//			int eduNo,
//			int mNo) throws Exception {
//		if (educationService.remove(eduNo, mNo) <= 0) {
//			return new AjaxResult("failure", null);
//		}
//		return new AjaxResult("success", null);
//	}
}
