package pms.controller.ajax;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pms.domain.AjaxResult;
import pms.domain.Diary;
import pms.domain.Files;
import pms.domain.Member;
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
			int mno,
			Member member,
			HttpSession session
			) throws Exception {
		 
		member = (Member) session.getAttribute("loginUser");
		List<Pet> pets = petService.getPetList(mno);
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("pets", pets);
		resultMap.put("User", member);
		
		return resultMap;
	}
	
	@RequestMapping("events")
	public Object events(
			int mno
			) throws Exception {
		 
		List<Diary> events = diaryService.getEventList(mno);	
		
		List dummyDate = new ArrayList();
		Map<String, Object> m;
		for (Diary d: events) {
			m = new HashMap<String, Object>();
			m.put("no", d.getDno());
			m.put("start", d.getStartDate());
			m.put("end", d.getEndDate());
			m.put("title", d.getTitle());
			m.put("description", d.getContent());
			m.put("hide", d.isDhide());
			m.put("color", d.getTagColor());
			dummyDate.add(m);
		}
		
		ObjectMapper om = new ObjectMapper();

		System.out.println(dummyDate);
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("events", dummyDate);

		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Diary diary
//			,Files files,
//			MultipartFile file
			) throws Exception {

//		if (file.getSize() > 0) {
//			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
//			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
//																  + "/" + newFileName);
//			file.transferTo(attachfile);
//			// 파일 만들어야 쓸수있겠군
//			files.setFileName(newFileName);
//		}
//		files.setDno(diary.getDno());
//		
//		filesService.add(files);
		

		if (diaryService.add(diary) <= 0) {
			return new AjaxResult("failure", null);
		} 
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
