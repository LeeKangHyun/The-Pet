package pms.controller.ajax;

import java.io.File;
import java.util.ArrayList;
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
import pms.domain.Mating;
import pms.service.CommentService;
import pms.service.DiaryService;
import pms.service.FilesService;
import pms.service.MatingService;
import pms.util.MultipartHelper;

@Controller("ajax.MatingController")
@RequestMapping("/mating/ajax/*")
public class MatingController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired MatingService matingService;
	@Autowired FilesService filesService;
	@Autowired CommentService commentService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping("list")
	public Object list() throws Exception {
		 
		List<Mating> mating = matingService.getMatingList();
		List<Files> files = null;
//		HashMap<String,Object> filesMap = new HashMap<>();
		List<List<Files>> filesMap = new ArrayList<>();
		int i = 0;
		for (Mating m : mating) {
			files = filesService.getMatFile(m.getMatNo());
			filesMap.add(files);
//			filesMap.put("files" + i, files);
			i++;
		}
			
			
			
//		List<Comment> comment = commentService.getMatComment();
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("mating", mating);
		resultMap.put("filesMap", filesMap);

		return resultMap;
	}
//	
//	@RequestMapping(value="add", method=RequestMethod.POST)
//	public Object add(
//			Diary diary,
//			int mno
//			) throws Exception {
//
//		Pet pet = petService.getOnePet(diary.getPno());
//		diary.setTagColor(pet.getTagColor());
//		diary.setpSpec(pet.getpSpec());
//		
//		if (diary.getStartDate().equals("")) {
//			Date d = new Date();
//      SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd");
//			diary.setStartDate(now.format(d));
//			diary.setEndDate(now.format(d));
//		}
//
//		diaryService.add(diary);
//		
//		List<Diary> events = diaryService.getEventList(mno);
//		int lastDno = 0;
//		for (Diary d : events) {
//			lastDno = d.getDno();
//		}
//
//		return new AjaxResult("success", lastDno);
//	}
//
//	@RequestMapping("delete")
//	public AjaxResult delete(
//			int dno) throws Exception {
//		
//		commentService.removeComment(dno);
//		filesService.removeDairyFile(dno);
//		diaryService.remove(dno);
//		 
//		return new AjaxResult("success", null);
//	}
//	
	/////////// 위까진 성공
	
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




	/*private String replace(String checkIndex) {
		if ( checkIndex != null ) {
			checkIndex = checkIndex.replaceAll("<","&lt;");
			checkIndex = checkIndex.replaceAll(">","&gt;");
		} 
		return checkIndex;

	}*/
}
