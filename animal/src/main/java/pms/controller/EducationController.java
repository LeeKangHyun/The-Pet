package pms.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pms.domain.Education;
import pms.service.EducationService;
import pms.util.MultipartHelper;

@Controller
@RequestMapping("/education/*")
public class EducationController {
	public static final String SAVED_DIR = "/attachfile";
	
	@Autowired EducationService eduService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping("list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align,
			Model model) throws Exception {
		List<Education> edus = eduService.getEducationList(
				pageNo, pageSize, keyword, align);
		model.addAttribute("edus", edus);
		
		return "education/EducationList";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form() {
		return "education/EducationForm";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Education education, MultipartFile file) throws Exception {
		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR)
																+ "/" + newFileName);
			file.transferTo(attachfile);
			education.setAttachFile(newFileName);
		}
		eduService.register(education);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("detail")
	public String detail(int eduNo, Model model) throws Exception {
		
		Education education = eduService.retrieve(eduNo);
		model.addAttribute("education", education);
		
		return "education/EducationDetail";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(
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
		
		eduService.change(education);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(
			int eduNo,
			int mno) throws Exception {
		eduService.remove(eduNo, mno);
		
		return "redirect:list.do";
	}
}
