package pms.controller.ajax;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Pet;
import pms.service.DiaryService;
import pms.service.FilesService;
import pms.service.PetService;
import pms.util.MultipartHelper;

@Controller("ajax.FilesController")
@RequestMapping("/files/ajax/*")
public class FilesController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired PetService petService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="upload", method=RequestMethod.POST)
	public Object add(
				Files files,
			  MultipartFile file
			) throws Exception {
 
	 	String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
		File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
															+ "/" + newFileName);
		file.transferTo(attachfile);
		files.setFileName(newFileName);

		filesService.add(files);
		
		return new AjaxResult("success", null);
	}
	
	@RequestMapping("list")
	public Object list(int dno) throws Exception {
		 
		List<Files> files = filesService.getDiaryFile(dno);

		return new AjaxResult("success", files);
	}
	
	@RequestMapping("matlist")
	public Object matlist(int matNo) throws Exception {
		 
		List<Files> files = filesService.getMatFile(matNo);

		return new AjaxResult("success", files);
	}
	
	/////// 아직 위까지만 사용
	
	@RequestMapping("detail")
	public Object detail(int pno) throws Exception {

		Pet pet = petService.getOnePet(pno);
		return new AjaxResult("success", pet);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(
			Diary diary,
			Files files,
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			// 파일 만들어야 쓸수있겠군
//			files.setFileName(fileName);(newFileName);
			
		}	else if (files.getFileName().length() == 0) {
			files.setFileName(null);
		}

		if (diaryService.change(diary) <= 0 || filesService.change(files) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

	@RequestMapping("delete")
	public AjaxResult delete(
			int dno) throws Exception {

		if (diaryService.remove(dno) <= 0) {
			return new AjaxResult("failure", null);
		} 
		filesService.removeDairyFile(dno);
		return new AjaxResult("success", null);
	}


	/*private String replace(String checkIndex) {
		if ( checkIndex != null ) {
			checkIndex = checkIndex.replaceAll("<","&lt;");
			checkIndex = checkIndex.replaceAll(">","&gt;");
		} 
		return checkIndex;

	}*/
}
