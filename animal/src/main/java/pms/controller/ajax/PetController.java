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

@Controller("ajax.PetController")
@RequestMapping("/pet/ajax/*")
public class PetController { 
	public static final String SAVED_DIR = "/files";
	
	@Autowired DiaryService diaryService;
	@Autowired PetService petService;
	@Autowired FilesService filesService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(int mno) throws Exception {
		 
		List<Pet> pets = petService.getPetList(mno);
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("pets", pets);

		return resultMap;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public Object add(Pet pet,
			  MultipartFile file) throws Exception {
		
		pet.setpImg("default.jpg");
		if (file != null) {	
		 	String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																+ "/" + newFileName);
			file.transferTo(attachfile);
			pet.setpImg(newFileName);
		}

		petService.addPet(pet);
		List<Pet> pets = petService.getPetList(pet.getMno());
		
		return new AjaxResult("success", pets);
	}

	@RequestMapping("detail")
	public Object detail(int pno) throws Exception {

		Pet pet = petService.getOnePet(pno);
		return new AjaxResult("success", pet);
	}
	
	@RequestMapping("delete")
	public AjaxResult delete(
			int pno) throws Exception {

		if (petService.remove(pno) <= 0) {
			return new AjaxResult("failure", null);
		} 

		return new AjaxResult("success", null);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(
			Pet pet,
			String oriImg,
			Diary diary,
			MultipartFile file) throws Exception {
	  
		if (file != null) {	
		 	String newFileName = MultipartHelper.generateFilename(file.getOriginalFilename());  
			File attachfile = new File(servletContext.getRealPath(SAVED_DIR) 
																+ "/" + newFileName);
			file.transferTo(attachfile);
			pet.setpImg(newFileName);
		}	else if (pet.getpImg().equals("default.jpg")) {
			pet.setpImg("default.jpg");
		} 
		
		if (petService.change(pet) <= 0) {
			return new AjaxResult("failure", null);
		}
		diary.setTagColor(pet.getTagColor());
		diary.setPno(pet.getPno());
		diaryService.changeColor(diary);
		List<Pet> pets = petService.getPetList(pet.getMno());
		return new AjaxResult("success", pets);
	}

}
