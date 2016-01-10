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
import pms.domain.Member;
import pms.service.FilesService;
import pms.service.MemberService;
import pms.service.PetService;
import pms.util.MultipartHelper;

@Controller("ajax.MemeberController")
@RequestMapping("/member/ajax/*")
public class MemberController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired MemberService memberService;
	@Autowired PetService petService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list() throws Exception {
		 
		List<Member> members = memberService.getMemberList();
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("members", members);
		
		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(
			Member member,
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			member.setmImg(newFileName);
		}
		memberService.register(member);
		return new AjaxResult("success", null);
	}

	@RequestMapping("detail")
	public Object detail(int mno) throws Exception {

		Member member = memberService.oneMember(mno);
		return new AjaxResult("success", member);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(
			Member member,
			MultipartFile file) throws Exception {

		if (file.getSize() > 0) {
			String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																	+ "/" + newFileName);
			file.transferTo(attachfile);
			member.setmImg(newFileName);
		}	else if (member.getmImg().length() == 0) {
			member.setmImg(null);
		}
		
		if (memberService.change(member) <= 0) {
			return new AjaxResult("failure", null);
		} 
		
		return new AjaxResult("success", null);
	}

	@RequestMapping("delete")
	public AjaxResult delete(
			int mno) throws Exception {

		if (memberService.remove(mno) <= 0) {
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
