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
import org.springframework.web.servlet.ModelAndView;

import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Pet;
import pms.service.DiaryService;
import pms.service.FilesService;
import pms.service.PetService;
import pms.util.MultipartHelper;

@Controller("ajax.DiaryController")
@RequestMapping("/diary/ajax/*")
public class DiaryController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired PetService petService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(
			int mno) throws Exception {

		List<Diary> pets = diaryService.getPetList(mno);
		List<Diary> events = diaryService.getEventList();

		HashMap<String,Object> resultMap = new HashMap<>();
		ModelAndView mav = new ModelAndView();
		resultMap.put("status", "success");
		resultMap.put("pets", pets);
		try {
			if(events!=null) {
				for (int i=0; i<=events.size(); i++) {
					resultMap.put("id", events.get(i).getDno());
					resultMap.put("start", events.get(i).getStartDate());
					resultMap.put("end", events.get(i).getEndDate());
					resultMap.put("title", events.get(i).getTitle());
					resultMap.put("content", events.get(i).getContent());
					resultMap.put("hide", events.get(i).isDhide());
					resultMap.put("color", events.get(i).getTagColor());
					
				}
				mav.addObject("data", resultMap);
				mav.setViewName("jsonView");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		resultMap.put("events", events);
		
//		return resultMap;
		return mav;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Diary diary,
			Files files,
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																  + "/" + newFileName);
			file.transferTo(attachfile);
			// 파일 만들어야 쓸수있겠군
			files.setFileName(newFileName);
		}
		files.setDno(diary.getDno());
		
		filesService.add(files);
		diaryService.add(diary);

		return new AjaxResult("success", null);
	}

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
			files.setFileName(newFileName);
			
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
