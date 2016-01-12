package pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pms.dao.EducationDao;
import pms.dao.FilesDao;
import pms.domain.Education;
import pms.domain.Files;
import pms.service.EducationService;

@Controller("ajax.EducationController")
@RequestMapping("/education/ajax/*")
public class EductionController {
	public static final String SAVED_DIR = "/files";
	
	@Autowired EducationDao educationDao;
	@Autowired EducationService educationService;
	@Autowired FilesDao filesDao;
	@Autowired ServletContext servletContext;
	
	
	@RequestMapping("list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="EDU_CRE") String keyword,
			@RequestParam(defaultValue="desc") String align,
			Files files) throws Exception {
		
		
		HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("startIndex", (pageNo - 1) * pageSize);
        paramMap.put("length", pageSize);
        paramMap.put("keyword", keyword);
        paramMap.put("align", align);
    
		List<Education> educations = educationDao.selectList(paramMap);
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", educations);
		
		return resultMap;
	}
//	
//	@RequestMapping(value="add", method=RequestMethod.POST)
//	public AjaxResult add(
//			Education education,
//			Member member,
//			Files files,
//			MultipartFile file) throws Exception {
//		
//		if (file.getSize() > 0) {
//			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
//			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
//														+ "/" + newFileName);
//			file.transferTo(attachfile);
//			
//			files.setFileName(newFileName);
//			
//		}
//		files.setEduNo(education.getEduNo());
//		
//		filesService.add(files);
//		educationService.add(education);
//		
//		return new AjaxResult("success", null);
//	}
//		
//	
	@RequestMapping("detail")
	public Object detail(int eduNo, Model model) throws Exception {
        
    educationDao.addViews(eduNo);
        
		Education education = educationService.getOneEducation(eduNo);
		model.addAttribute("education", education);
		
		return "education/EducationDetail";
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
