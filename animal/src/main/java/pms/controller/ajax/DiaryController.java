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
import pms.service.DiaryService;
import pms.util.MultipartHelper;

@Controller("ajax.DiaryController")
@RequestMapping("/diary/ajax/*")
public class DiaryController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(
			int mno) throws Exception {

		List<Diary> pets = diaryService.getPetList(mno);
		List<Diary> events = diaryService.getEventList();

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("pets", pets);
		resultMap.put("events", events);

		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Diary diary, 
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																  + "/" + newFileName);
			file.transferTo(attachfile);
			// 파일 만들어야 쓸수있겠군
			//board.setAttachFile(newFileName);
		}

		diaryService.add(diary);

		return new AjaxResult("success", null);
	}

	@RequestMapping("detail")
	public Object detail(int no) throws Exception {

		Board board = boardDao.selectOne(no);
		return new AjaxResult("success", board);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(
			Board board
			/*, MultipartFile file,*/) throws Exception {


		/*if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			board.setAttachFile(newFileName);
			
		}	else if (board.getAttachFile().length() == 0) {
			board.setAttachFile(null);
		}*/

		if (boardDao.update(board) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

	@RequestMapping("delete")
	public AjaxResult delete(
			int no,
			String password) throws Exception {

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("no", no);
		paramMap.put("password", password);

		if (boardDao.delete(paramMap) <= 0) {
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
