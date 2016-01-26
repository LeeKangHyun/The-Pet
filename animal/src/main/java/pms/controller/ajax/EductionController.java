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

import pms.dao.EducationDao;
import pms.dao.FilesDao;
import pms.domain.AjaxResult;
import pms.domain.Education;
import pms.domain.Files;
import pms.service.EducationService;

@Controller("ajax.EducationController")
@RequestMapping("/Education/education/ajax/*")
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
			@RequestParam(defaultValue="desc") String align) throws Exception {
		
		
		HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("startIndex", (pageNo - 1) * pageSize);
        paramMap.put("length", pageSize);
        paramMap.put("keyword", keyword);
        paramMap.put("align", align);
    
		List<Education> educations = educationDao.selectList(paramMap);
		List<Files> files = null;
		List<List<Files>> filesMap = new ArrayList<>();
		
		for (Education e : educations) {
			files = filesDao.EduFileList(e.getEduNo());
			filesMap.add(files);
			System.out.println(files);
			System.out.println(filesMap);
		}
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", educations);
		resultMap.put("filesMap", filesMap);
		
		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Education education) throws Exception {
		
		educationDao.insert(education);
		HashMap<String,Object> paramMap = new HashMap<>();
		
		List<Education> educations = educationDao.selectList(paramMap);
		Education e = educations.get(0);
		int eduNo = e.getEduNo();
		System.out.println(eduNo);
		return new AjaxResult("success", eduNo);
	}
		
	
	@RequestMapping("detail")
	public Object detail(int eduNo) throws Exception {
    educationDao.addViews(eduNo);
		Education education = educationDao.selectOne(eduNo);
		
		return new AjaxResult("success", education);
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
