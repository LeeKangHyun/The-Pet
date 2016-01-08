package pms.controller.ajax;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pms.dao.EducationDao;
import pms.domain.AjaxResult;
import pms.domain.Education;
import pms.util.MultipartHelper;

@Controller("ajax.EducationController")
@RequestMapping("/education/ajax/*")
public class EducationController {
	public static final String SAVED_DIR = "/attachfile";
	
	@Autowired EducationDao educationDao;
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
		
		List<Education> edus = educationDao.selectList(paramMap);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", edus);
		
		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form() {
		return "education/EducationForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(Education education, MultipartFile file) throws Exception {
		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR)
																+ "/" + newFileName);
			file.transferTo(attachfile);
			education.setAttachFile(newFileName);
		}
		educationDao.insert(education);
		
		return new AjaxResult("success", file);
	}
	
	@RequestMapping("detail")
	public Object detail(int eduNo) throws Exception {
		
		Education education = educationDao.selectOne(eduNo);
		
		return new AjaxResult("success", education);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(
			Education education,
			MultipartFile file) throws Exception {
		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR)
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			education.setAttachFile(newFileName);
			
		} else if (education.getAttachFile().length() == 0) {
			education.setAttachFile(null);
		}
		
		if (educationDao.update(education) <= 0) {
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", file);
	}
	
	@RequestMapping("delete.do")
	public AjaxResult delete(
			int eduNo,
			int mno) throws Exception {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("eduNo", eduNo);
		paramMap.put("mno", mno);
		
		if (educationDao.delete(eduNo, mno) <= 0) {
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
}
